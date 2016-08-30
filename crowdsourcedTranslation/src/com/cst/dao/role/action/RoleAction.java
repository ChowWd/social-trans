package com.cst.dao.role.action;

import java.io.File;
import java.rmi.ServerException;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;

import com.cst.dao.core.action.BaseAction;
import com.cst.dao.core.constant.Constant;
import com.cst.dao.role.entity.Role;
import com.cst.dao.role.entity.RolePrivilege;
import com.cst.dao.role.entity.RolePrivilegeId;
import com.cst.dao.role.service.RoleService;
import com.opensymphony.xwork2.ActionContext;

public class RoleAction extends BaseAction {

	@Resource
	private RoleService roleService;
	private List<Role> roleList;// �û��б�
	private Role role;
	private String[] privilegeIds;// Ȩ�޼���

	// ��ת��ҳ�����ַ�����ʾ
	// �б�ҳ��
	public String listUI() throws Exception {
		// ����Ȩ�޼���
		ActionContext.getContext().getContextMap()
				.put("privilegeMap", Constant.PRIVILEGE_MAP);
		try {
			roleList = roleService.findObjects();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}

		return "listUI";
	}

	// ��ת������ҳ��
	public String addUI() {
		// ����Ȩ�޼���
		ActionContext.getContext().getContextMap()
				.put("privilegeMap", Constant.PRIVILEGE_MAP);
		return "addUI";
	}

	// ��������
	public String add() {
		try {
			if (role != null) {
				// ����Ȩ�ޱ���
				if (privilegeIds != null) {
					// ����һ����ϣ����set
					HashSet<RolePrivilege> set = new HashSet<RolePrivilege>();
					// ѭ��ȡ��privilegeIds�����е�Ȩ��ֵ
					for (int i = 0; i < privilegeIds.length; i++) {
						// ��ӵ���ϣset��
						set.add(new RolePrivilege(new RolePrivilegeId(role,
								privilegeIds[i])));
					}
					role.setRolePrivileges(set);
				}
				roleService.save(role);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "list";
	}

	// ��ת���༭ҳ��
	public String editUI() {
		// ����Ȩ�޼���
		ActionContext.getContext().getContextMap()
				.put("privilegeMap", Constant.PRIVILEGE_MAP);
		if (role != null && role.getRoleId() != null) {
			role = roleService.findObjectById(role.getRoleId());
			//����Ȩ�޻���
			//Ȩ�޼��ϲ�Ϊ��
			if(role.getRolePrivileges() != null){
				//��ȡ���ϳ���
				privilegeIds = new String[role.getRolePrivileges().size()];
				int i = 0;
				//ѭ����ֵ
				for(RolePrivilege rp: role.getRolePrivileges()){
					privilegeIds[i++] = rp.getId().getCode();
				}
			}
		}
		return "editUI";
	}

	// ����༭
	public String edit() {
		System.out.println("edit");
		try {
			if (role != null) {
				if (privilegeIds != null) {
					// ����һ����ϣ����set
					HashSet<RolePrivilege> set = new HashSet<RolePrivilege>();
					// ѭ��ȡ��privilegeIds�����е�Ȩ��ֵ
					for (int i = 0; i < privilegeIds.length; i++) {
						// ��ӵ���ϣset��
						set.add(new RolePrivilege(new RolePrivilegeId(role,
								privilegeIds[i])));
					}
					role.setRolePrivileges(set);
				}
				roleService.update(role);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "list";
	}

	// ɾ��
	public String delete() {
		if (role != null && role.getRoleId() != null) {
			roleService.delete(role.getRoleId());
		}
		return "list";
	}

	// ����ɾ��
	public String deleteSelected() {
		if (selectedRow != null) {
			for (String id : selectedRow) {
				roleService.delete(id);
			}
		}
		return "list";
	}

	public List<Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String[] getPrivilegeIds() {
		return privilegeIds;
	}

	public void setPrivilegeIds(String[] privilegeIds) {
		this.privilegeIds = privilegeIds;
	}
}
