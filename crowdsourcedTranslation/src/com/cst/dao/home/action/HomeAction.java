package com.cst.dao.home.action;

import com.opensymphony.xwork2.ActionSupport;

public class HomeAction extends ActionSupport {
	
	
	public String frame(){
		return "frame";
	}
	
	//��ת������
	public String top(){
		return "top";
	}
	//��ת����߲˵�
	public String left(){
		return "left";
	}
}
