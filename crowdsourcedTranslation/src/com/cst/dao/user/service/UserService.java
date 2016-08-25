package com.cst.dao.user.service;

import java.io.Serializable;
import java.util.List;

import com.cst.dao.user.entity.User;

public interface UserService {
	
	//����
	public void save(User user);
	//����
	public void update(User user);
	//����idɾ��
	public void delete(Serializable id);
	//����id����
	public User findObjectById(Serializable id);
	//�����б�
	public List<User> findObjects();
}
