package com.cst.dao.core.constant;

import java.util.HashMap;
import java.util.Map;

public class Constant {
	
	//ϵͳ���û���session�еı�ʶ��
	public static String USER = "SYS_USER";
		
	/*----------------------ϵͳȨ�޼���--------------------------*/
	public static String PRIVILEGE_YHGL = "yhgl"; //�û�����
	public static String PRIVILEGE_JSGL= "jsgl"; //��ɫ����
	public static String PRIVILEGE_RWGL = "rwgl"; //�������
	

	public static Map<String, String> PRIVILEGE_MAP;
	static {
		PRIVILEGE_MAP = new HashMap<String, String>();
		PRIVILEGE_MAP.put(PRIVILEGE_YHGL, "�û�����");
		PRIVILEGE_MAP.put(PRIVILEGE_JSGL, "��ɫ����");
		PRIVILEGE_MAP.put(PRIVILEGE_RWGL, "�������");
		
	}
}
