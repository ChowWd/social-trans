package com.cst.dao.user.dao;

import java.util.List;

import com.cst.dao.core.dao.BaseDao;
import com.cst.dao.user.entity.User;
import com.cst.dao.user.entity.UserRole;

public interface UserDao extends BaseDao<User> {

	List<User> findUserByAccountAndId(String account, String id);
	
	//�����û���ɫ
	public void saveUserRole(UserRole userRole);
	
	//�����û�idɾ���û����еĽ�ɫ
	public void deleteUserRoleByUserId(String id);

	public List<UserRole> getUserRolesByUserId(String id);

}
