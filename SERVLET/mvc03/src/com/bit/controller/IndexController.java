package com.bit.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 주소를 통해서 명령을 받음 = servlet
 * 
 *
 */
public class IndexController extends HttpServlet{
	//주소를 index.bit를 쓰겠음
	
	//index는 view 만 사용하기에 model 쓰지 않는다.
	//request scope를 유지하면서 해야한다.
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("index.jsp");	//여기에 써준 파일이 index.bit을 쳤을 때 나옴
		rd.forward(req, resp);
	}
}
