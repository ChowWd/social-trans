package com.cst.dao.user.entity;

import java.io.Serializable;

public class User implements Serializable {
	
	private String id;
	private String account;//�ʺ�
	private String password;//����
	private String name;//�û���
	private String headImage;//ͷ��
	private String email;//����
	private String mobile;//�ֻ�
	private String bankCard;//���п�
	private String realName;//��ʵ����
	private String identityCard;//���֤
	private Boolean gender;//�Ա�
	
	
	
	//��ɫ״̬
	public static String USER_STATE_VALID = "1";//��Ч
	public static String USER_STATE_INVALID = "0";//��Ч
	





	public User(String id, String account, String password, String name,
			String headImage, String email, String mobile, String bankCard,
			String realName, String identityCard, Boolean gender) {
		super();
		this.id = id;
		this.account = account;
		this.password = password;
		this.name = name;
		this.headImage = headImage;
		this.email = email;
		this.mobile = mobile;
		this.bankCard = bankCard;
		this.realName = realName;
		this.identityCard = identityCard;
		this.gender = gender;
	}


	public Boolean getGender() {
		return gender;
	}



	public void setGender(Boolean gender) {
		this.gender = gender;
	}

	public User() {
		
	}
	
	
	
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHeadImage() {
		return headImage;
	}
	public void setHeadImage(String headImage) {
		this.headImage = headImage;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getBankCard() {
		return bankCard;
	}
	public void setBankCard(String bankCard) {
		this.bankCard = bankCard;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getIdentityCard() {
		return identityCard;
	}
	public void setIdentityCard(String identityCard) {
		this.identityCard = identityCard;
	}
	
	
	
}
