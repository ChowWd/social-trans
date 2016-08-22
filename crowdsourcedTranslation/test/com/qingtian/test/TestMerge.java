package com.qingtian.test;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;




import com.qingtian.test.entity.Person;
import com.qingtian.test.service.TestService;

public class TestMerge {
	
	private ClassPathXmlApplicationContext context;
	
	@Before
	public void init(){
		context=new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	
	@Test
	public void testSpring(){
		TestService testService=(TestService) context.getBean("testService");
		testService.say();
	}
	
	@Test
	public void testHibernate() {
		SessionFactory sf = (SessionFactory)context.getBean("sessionFactory");
		
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		//������Ա
		session.save(new Person("��Ա1"));
		transaction.commit();
		session.close();
	}
	
	@Test
	public void testServiceAndDao(){
		TestService testService=(TestService) context.getBean("testService");
		testService.save(new Person("С��"));
	}
	
	@Test
	public void testTansactionReadOnly(){
		TestService testService=(TestService) context.getBean("testService");
		testService.findPerson("5e91ebf156a217030156a21703c20000");
	}
}
