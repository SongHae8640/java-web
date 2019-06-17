package com.bit.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.model.Guest01Dao;

public class AddController extends HttpServlet{
	// / add.bit
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("add.jsp");
		rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		String param1 = req.getParameter("sub");
		String param2 = req.getParameter("nalja");
		String param3 = req.getParameter("pay");
		
		String sub = param1.trim();
		String nalja = param2;
		int pay = Integer.parseInt(param3);
		
		System.out.println(sub+nalja+pay);
		
		Guest01Dao dao = new Guest01Dao();
		dao.insert(sub,nalja,pay);
		
		//리스트 페이지로 재접속
		resp.sendRedirect("list.bit");
	}
}
