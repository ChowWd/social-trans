package com.qingtian.test.dao;

import java.io.Serializable;

import com.qingtian.test.entity.Person;

public interface TestDao {
	// ������Ա
	public void save(Person person);

	// ����id��ѯ��Ա
	public Person findPerson(Serializable id);

}
