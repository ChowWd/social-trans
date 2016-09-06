package com.cst.dao.core.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;








import com.cst.dao.core.constant.Constant;
import com.cst.dao.core.permission.PermissionCheck;
import com.cst.dao.user.entity.User;



public class LoginFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)servletRequest;
		HttpServletResponse response = (HttpServletResponse)servletResponse;
		String uri = request.getRequestURI();
		//�жϵ�ǰ�����ַ�Ƿ��ǵ�¼�������ַ
		if(!uri.contains("sys/login_")){
			//�ǵ�¼����
			if(request.getSession().getAttribute(Constant.USER) != null){
				User user = (User)request.getSession().getAttribute(Constant.USER);
				//��ȡspring����
				WebApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(request.getSession().getServletContext());
				PermissionCheck pc = (PermissionCheck)applicationContext.getBean("permissionCheck");
				//˵���Ѿ���¼��
				chain.doFilter(request, response);
				}else {
				//û�е�¼����ת����¼ҳ��
				response.sendRedirect(request.getContextPath() + "/sys/login_toLoginUI.action");
			}
		} else {
			//��¼����ֱ�ӷ���
			chain.doFilter(request, response);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
