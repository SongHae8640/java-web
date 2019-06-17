package com.bit.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.model.Guest01Dao;
import com.bit.model.Guest01Dto;

public class EditController extends HttpServlet {
	//	/edit.bit

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String param=req.getParameter("idx");
		int num=Integer.parseInt(param);
		
		Guest01Dao dao=new Guest01Dao();
		Guest01Dto bean=dao.getDetail(num);
		
		req.setAttribute("bean", bean);
		
		RequestDispatcher rd =null;
		rd=req.getRequestDispatcher("edit.jsp");
		rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String param1=req.getParameter("num");
		String param2=req.getParameter("sub");
		String param3=req.getParameter("nalja");
		String param4=req.getParameter("pay");
		
		int num=Integer.parseInt(param1);
		String sub=param2.trim();
		String nalja=param3;
		int pay=Integer.parseInt(param4);
		
		Guest01Dao dao=new Guest01Dao();
		int result=dao.update(num, sub, nalja, pay);
		if(result>0){
			//
			resp.sendRedirect("detail.bit?idx="+num);
		}else{
			//
			doGet(req,resp);
		}
	}
}
