package com.bit.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;

import com.bit.model.Guest02Dao;

@WebServlet("/add.bit")
public class AddController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("add.jsp");
		rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setCharacterEncoding("utf-8");
		
		//guest02에 필요한 파라미터 
		String sub = req.getParameter("sub");
		int unum = Integer.parseInt(req.getParameter("unum"));
		int pay = Integer.parseInt(req.getParameter("pay"));
		
		//ueser02에 필요한 파라미터
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		String name = req.getParameter("name");
		
		//db에 추가
		Guest02Dao dao = new Guest02Dao();
		dao.add(sub, unum, pay, id, pw, name);
		
		//확인 출력
		PrintWriter out = resp.getWriter();
		out.print("<h1>success</h1>");
		out.close();
		
	}
}
