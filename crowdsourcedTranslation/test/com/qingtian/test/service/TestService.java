package com.qingtian.test.service;

import java.io.Serializable;

import com.qingtian.test.entity.Person;



public interface TestService {
		
	public void say();
	
	//������Ա
	public void save(Person person);
	
	//����id��ѯ��Ա
	public Person findPerson(Serializable id);
}
