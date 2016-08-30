package com.cst.dao.role.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;

import com.cst.dao.core.dao.impl.BaseDaoImpl;
import com.cst.dao.role.dao.RoleDao;
import com.cst.dao.role.entity.Role;

public class RoleDaoImpl extends BaseDaoImpl<Role> implements RoleDao {
	
	//ɾ���ý�ɫ���ڵ�����Ȩ��
	@Override
	public void deleteRolePrivilegeByRoleId(String roleId) {
		//ɾ����ɫȨ�ޱ��ж�Ӧid�Ľ�ɫ�Ľ�ɫid
		Query query = getSession().createQuery("DELETE FROM RolePrivilege WHERE id.role.roleId=?");
		//����roleId����
		query.setParameter(0, roleId);
		//ִ�и��²���
		query.executeUpdate();
	}

	

}
