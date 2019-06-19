package com.bit.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.model.Guest02Dao;
import com.bit.model.Guest02Dto;

/**
 * -RequestDispatcher
 * a.jsp로 들어온 요청을 a.jsp 내에서 RequestDispatcher를 사용하여 b.jsp로 요청을 보낼 수 있다.
 * 또한 a.jsp에서 b.jsp로 처리를 요청하고 b.jsp에서 처리한 결과 내용을 a.jsp의 결과에 포함 시킬 수 있다.
 * 서버 내에서 request가 이동한다고 보면 된다.
 * 
 * -sendRedirect와의 차이
 * sendRedirect는 지정된 경로로 제어를 이동시키는 방법 중 하나다. 그러나 HTTP 리다이렌션을 이용하기 때문에
 * 하나의 요청 범위 안에서 처리하는 것이 아니라 브라우저에게 Response 후 브라우저 측에서 지정 받은 요청 경로로
 * 다시 재 요청을 하는 방식이다(왔다 갔다). 쿠키나 세션을 이용한 공유는 가능하다. 
 * + 현재 어플리케이션 이외의 다른 경로를 요청할 수 있다.
 * 
 * -forword 메서드
 * 해당 jsp로 대상 자원의 제어를 넘긴다. 
 * 넘긴 자원만! 전달 된다.
 */

public class ListController extends HttpServlet{
	// /bbs/list.bit
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//model
		Guest02Dao dao = new Guest02Dao();
		req.setAttribute("list", dao.getList());
		
		//view
		//.jsp에서의 리스트 주소는 /mvc04/bbs/list.bit
		// web.xml에서 ListController를 가리키는 주소는 /bbs/list.bit
		// WebContent 아래 bbs폴더를 만들어 놨다면 아래처럼, 아니라면 ../을 통해서 상위로
		RequestDispatcher rd = req.getRequestDispatcher("./list.jsp");
		rd.forward(req, resp);
	}
}
