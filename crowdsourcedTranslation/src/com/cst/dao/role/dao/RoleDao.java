package com.cst.dao.role.dao;

import com.cst.dao.core.dao.BaseDao;
import com.cst.dao.role.entity.Role;

public interface RoleDao extends BaseDao<Role> {
	
	//ɾ���ý�ɫ���ڵ�����Ȩ��
	public void deleteRolePrivilegeByRoleId(String roleId);
	
}
