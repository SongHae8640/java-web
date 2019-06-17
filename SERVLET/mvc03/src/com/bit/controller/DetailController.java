package com.bit.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.model.Guest01Dao;
import com.bit.model.Guest01Dto;

public class DetailController extends HttpServlet{
	// detail.bit
	 @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String param = req.getParameter("idx");
		int num = Integer.parseInt(param);
		
		//model에서 내용 가져오기
		Guest01Dao dao = new Guest01Dao();
		Guest01Dto bean = dao.getDetail(num);
		
		req.setAttribute("bean", bean);
		
		//view
		RequestDispatcher rd = req.getRequestDispatcher("detail.jsp");
		rd.forward(req, resp);
	}
}
