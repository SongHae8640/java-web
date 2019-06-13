package com.bit.test01;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

//사용하는 부분은 service만 사용하니 이 메서드만 빼서 사용
public class Ex02 extends MyWeb{

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}

abstract class MyWeb implements Servlet{
	ServletConfig config; 
	@Override
	public void destroy() {}

	@Override
	public ServletConfig getServletConfig() {
		return config;
	}

	@Override
	public String getServletInfo() {
		return "";
	}

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		config = arg0;	
	}

	@Override
	public abstract void service(ServletRequest arg0, ServletResponse arg1)
			throws ServletException, IOException;
	
}