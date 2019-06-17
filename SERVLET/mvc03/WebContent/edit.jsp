<%@page import="com.bit.model.Guest01Dto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="js/jquery-1.12.4.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
	})
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		Guest01Dto bean=(Guest01Dto)request.getAttribute("bean");
	%>
	<h1>수정페이지</h1>
	<form method="post">
		<div>
			<label for="num">num</label>
			<input type="text" name="num" id="num" value="<%=bean.getNum() %>" readonly="readonly"/>
		</div>
		<div>
			<label for="sub">sub</label>
			<input type="text" name="sub" id="sub" value="<%=bean.getSub() %>"/>
		</div>
		<div>
			<label for="nalja">nalja</label>
			<input type="date" name="nalja" id="nalja" value="<%=bean.getNalja() %>" />
		</div>
		<div>
			<label for="pay">pay</label>
			<input type="number" name="pay" id="pay" value="<%=bean.getPay() %>" />
		</div>
		<div>
			<button type="submit">수정</button>
			<button type="reset">취소</button>
			<button type="button">뒤로</button>
		</div>
	</form>
</body>
</html>