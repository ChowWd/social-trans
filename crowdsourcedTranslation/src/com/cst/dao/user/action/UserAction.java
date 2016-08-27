package com.cst.dao.user.action;

import java.io.File;
import java.rmi.ServerException;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;

import com.cst.dao.core.action.BaseAction;
import com.cst.dao.core.execption.ActionException;
import com.cst.dao.user.entity.User;
import com.cst.dao.user.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends BaseAction {
	
	@Resource
	private UserService userService;
	private List<User> userList;//�û��б�
	private User user;

	
	private File headImage;//�û�ͷ��
	private String headImageFileName;//ͷ����
	

	
	//��ת��ҳ�����ַ�����ʾ
	//�б�ҳ��
	public String listUI() throws Exception{
		try {
			userList = userService.findObjects();
		} catch (ServerException e) {
			// TODO Auto-generated catch block
			throw new Exception(e.getMessage());
		}
		return "listUI";
	}
	//��ת������ҳ��
	public String addUI(){
		return "addUI";
	}
	//��������
	public String add(){
		try {
			if(user != null){
				//����ͷ��
				if(headImage != null){
					//1������ͷ��upload/user
					//�Ժ�ͼƬ���ڷ���������url��ȡ
					//��ȡ����·���ľ��Ե�ַ
					String filePath = ServletActionContext.getServletContext().getRealPath("upload/user");
					//����UUID����һ��36λ�������
					//replaceAll("-","")��������������е�-�ÿ��ַ�����
					String fileName = UUID.randomUUID().toString().replaceAll("-", "") + headImageFileName.substring(headImageFileName.lastIndexOf("."));
					//String fileName="abc";
					//�����ļ�
					//File(�ļ���ַ���ļ���)
					FileUtils.copyFile(headImage, new File(filePath, fileName));
					
					//2�������û�ͷ��·��
					user.setHeadImage("user/" + fileName);
				}
				userService.save(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "list";
	}
	//��ת���༭ҳ��
	public String editUI(){
		if (user != null && user.getId() != null) {
			user = userService.findObjectById(user.getId());
		}
		return "editUI";
	}
	//����༭
	public String edit(){
		System.out.println("edit");
		try {
			if(user != null){
				//����ͷ��
				if(headImage != null){
					//1������ͷ��upload/user
					//�Ժ�ͼƬ���ڷ���������url��ȡ
					//��ȡ����·���ľ��Ե�ַ
					String filePath = ServletActionContext.getServletContext().getRealPath("upload/user");
					//����UUID����һ��36λ�������
					//replaceAll("-","")��������������е�-�ÿ��ַ�����
					String fileName = UUID.randomUUID().toString().replaceAll("-", "") + headImageFileName.substring(headImageFileName.lastIndexOf("."));
					//�����ļ�
					//File(�ļ���ַ���ļ���)
					FileUtils.copyFile(headImage, new File(filePath, fileName));
					
					//2�������û�ͷ��·��
					user.setHeadImage("user/" + fileName);
				}
				userService.update(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "list";
	}
	
	//ɾ��
	public String delete(){
		if(user != null && user.getId() != null){
			userService.delete(user.getId());
		}
		return "list";
	}
	//����ɾ��
	public String deleteSelected(){
		if(selectedRow != null){
			for(String id: selectedRow){
				userService.delete(id);
			}
		}
		return "list";
	}
	
	//У���û��ʺ�Ψһ
		public void verifyAccount(){
			try {
				//1����ȡ�ʺ�
				//user.getAccount().equals(' ') && user.getAccount() != null
				if(user != null && StringUtils.isNotBlank(user.getAccount())){
					//2�������ʺŵ����ݿ���У���Ƿ���ڸ��ʺŶ�Ӧ���û�
					List<User> list = userService.findUserByAccountAndId(user.getAccount(),user.getId());
					String strResult = "true";
					if(list != null && list.size() > 0){
						//˵�����ʺ��Ѿ�����
						strResult = "false";
					}
					
					//���
					HttpServletResponse response = ServletActionContext.getResponse();
					response.setContentType("text/html");
					ServletOutputStream outputStream = response.getOutputStream();
					outputStream.write(strResult.getBytes());
					outputStream.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	
	public List<User> getUserList() {
		return userList;
	}
	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	

	
	public File getHeadImage() {
		return headImage;
	}
	public void setHeadImage(File headImage) {
		this.headImage = headImage;
	}
	public String getHeadImageFileName() {
		return headImageFileName;
	}
	public void setHeadImageFileName(String headImageFileName) {
		this.headImageFileName = headImageFileName;
	}
}
