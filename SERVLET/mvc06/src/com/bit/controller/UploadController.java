package com.bit.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/upload.bit")
public class UploadController  extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
//		RequestDispatcher rd = req.getRequestDispatcher("uploadFile.jsp");
		RequestDispatcher rd = req.getRequestDispatcher("ajaxFile.jsp");
		rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		final int MB = 1024*1024;
		int maxSize = 10*MB;// 단위는 바이트
		
		
		String path = "C:\\java\\workspaceWeb\\mvc06\\WebContent\\fileLoad";
		
		//fileLoad의 진짜 경로를 알아보자
		path = req.getRealPath("/fileLoad");
		System.out.println("RealPath :: "+ path);
				
		//파일명 중복 처리
		//파일명이 같으면 덮어쓰기가 된다. > 파일명 변경되야 함 > cos가 제공
		DefaultFileRenamePolicy dfrp = new DefaultFileRenamePolicy();
		
		// 두번째 인자는 서버의 위치 ,세번째 인자는 파일 사이즈
		// 세번째 인자 인코딩 방식, 네번째 인자 rename 정책
		MultipartRequest mr = new MultipartRequest(req,path ,maxSize,"utf-8",dfrp);	
		
		//mr로 인자도 받을 수 있다.
		System.out.println("mr id ::"+mr.getParameter("id"));
		
		String origin = mr.getOriginalFileName("myFile");
		String reName = mr.getFilesystemName("myFile");	//변경된 이름을 받아야 하기 때문에
		
		req.setAttribute("fileName", reName);
		RequestDispatcher rd = req.getRequestDispatcher("downloadFile.jsp");
		rd.forward(req, resp);
		
		
		//새로고침을 해야만하는 이유
		//업로드된 경로와 실제 경로가 다르기 때문에 
		//새로고침 하면 path에 있는 경로가 복사 되기 때문에
		//이클립스를 통해 서비스되는 곳은 웹에 있는 서버에 ...
		// 그 경로는  C:\java\workspaceWeb\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\mvc06\fileLoad
		// 새로고침하면 파일이 위 경로로 복사 되기 때문에 실행 되는 것 
		// 그래서 위 경로에 올려도 위 경로가 temp0 이기 때문에 
		
		
		
	}
}
