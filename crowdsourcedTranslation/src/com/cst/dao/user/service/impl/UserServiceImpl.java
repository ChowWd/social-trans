package com.cst.dao.user.service.impl;

import java.io.Serializable;
import java.rmi.ServerException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cst.dao.user.dao.UserDao;
import com.cst.dao.user.entity.User;
import com.cst.dao.user.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Resource 
	private UserDao userDao;
	
	@Override
	public void save(User user) {
		// TODO Auto-generated method stub
		userDao.save(user);
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		userDao.update(user);
	}

	@Override
	public void delete(Serializable id) {
		// TODO Auto-generated method stub
		userDao.delete(id);
	}

	@Override
	public User findObjectById(Serializable id) {
		// TODO Auto-generated method stub
		return userDao.findObjectById(id);
	}

	@Override
	public List<User> findObjects() throws ServerException{
		try {
			//int i=1/0;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new ServerException("service����"+e.getMessage());
		}
		
		return userDao.findObjects();
	}

	@Override
	public List<User> findUserByAccountAndId(String account, String id) {
		// TODO Auto-generated method stub
		return userDao.findUserByAccountAndId(account,id);
	}
	
	//�����û������Ӧ�Ľ�ɫ
	@Override
	public void saveUserAndRole(User user, String... roleIds) {
		// TODO Auto-generated method stub
		
	}
	
	//�����û������Ӧ�Ľ�ɫ
	@Override
	public void updateUserAndRole(User user, String... roleIds) {
		// TODO Auto-generated method stub
		
	}

}
