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
		int maxSize = 10*MB;// ������ ����Ʈ
		
		
		String path = "C:\\java\\workspaceWeb\\mvc06\\WebContent\\fileLoad";
		
		//fileLoad�� ��¥ ��θ� �˾ƺ���
		path = req.getRealPath("/fileLoad");
		System.out.println("RealPath :: "+ path);
				
		//���ϸ� �ߺ� ó��
		//���ϸ��� ������ ����Ⱑ �ȴ�. > ���ϸ� ����Ǿ� �� > cos�� ����
		DefaultFileRenamePolicy dfrp = new DefaultFileRenamePolicy();
		
		// �ι�° ���ڴ� ������ ��ġ ,����° ���ڴ� ���� ������
		// ����° ���� ���ڵ� ���, �׹�° ���� rename ��å
		MultipartRequest mr = new MultipartRequest(req,path ,maxSize,"utf-8",dfrp);	
		
		//mr�� ���ڵ� ���� �� �ִ�.
		System.out.println("mr id ::"+mr.getParameter("id"));
		
		String origin = mr.getOriginalFileName("myFile");
		String reName = mr.getFilesystemName("myFile");	//����� �̸��� �޾ƾ� �ϱ� ������
		
		req.setAttribute("fileName", reName);
		RequestDispatcher rd = req.getRequestDispatcher("downloadFile.jsp");
		rd.forward(req, resp);
		
		
		//���ΰ�ħ�� �ؾ߸��ϴ� ����
		//���ε�� ��ο� ���� ��ΰ� �ٸ��� ������ 
		//���ΰ�ħ �ϸ� path�� �ִ� ��ΰ� ���� �Ǳ� ������
		//��Ŭ������ ���� ���񽺵Ǵ� ���� ���� �ִ� ������ ...
		// �� ��δ�  C:\java\workspaceWeb\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\mvc06\fileLoad
		// ���ΰ�ħ�ϸ� ������ �� ��η� ���� �Ǳ� ������ ���� �Ǵ� �� 
		// �׷��� �� ��ο� �÷��� �� ��ΰ� temp0 �̱� ������ 
		
		
		
	}
}
