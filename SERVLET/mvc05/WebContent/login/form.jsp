<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	<link type="text/css" rel="stylesheet" href="../css/frame.css" />
	<script type="text/javascript" src="../js/jquery-1.12.4.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			$('button[type="button"]').click(function(){
				window.location.href = "join.jsp";
			});

		})

	</script>
</head>

<body>
	<div>
		<div id="header">
			<h1>비트교육센서</h1>
		</div>
		<div id="menu">
			<% String root = request.getContextPath();%>
			<ul>
				<li><a href="<%=root %>/">HOME</a></li>
				<li><a href="<%=root %>/intro.bit">INTRO</a></li>
				<li><a href="<%=root %>/bbs/list.bit">BBS</a></li>
				<%if(session.getAttribute("result")==null){ %>
				<li><a href="<%=root %>/login/form.bit">LOGIN</a></li>
				<%}else{ %>
				<li><a href="<%=root %>/login/logout.bit">LOGOUT</a></li>
				<%} %>
			</ul>
		</div>
		<div id="content">
			<h2>로그인 페이지</h2>
			<form action="form.bit" method="post">
				<div>
					<label for="id">id</label>
					<input type="text" name="id" id="id">
				</div>
				<div>
					<label for="pw">pw</label>
					<input type="text" name="pw" id="pw">
				</div>
				<div>
					<button type="submit">로그인</button>
					<button type="reset">취소</button>
					<button type="button">회원가입</button>
				</div>
			</form>
			
		</div>
		<div id="footer">
			Copyright &copy; 비트캠프 All rights
		</div>

	</div>
	<%
		Object err = request.getAttribute("errmsg");
		if(err !=null)out.println(err);
	%>

</body>

</html>
