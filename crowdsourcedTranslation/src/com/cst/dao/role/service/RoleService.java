package com.cst.dao.role.service;

import java.io.Serializable;
import java.rmi.ServerException;
import java.util.List;

import com.cst.dao.role.entity.Role;



public interface RoleService {
		
		//����
		public void save(Role role);
		//����
		public void update(Role role);
		//����idɾ��
		public void delete(Serializable id);
		//����id����
		public Role findObjectById(Serializable id);
		//�����б�
		public List<Role> findObjects();
}
