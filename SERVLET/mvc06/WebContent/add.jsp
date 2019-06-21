<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
</head>

<body>
	<form action="add.bit" method="post">
		<!-- 두개의 테이블에 한번에 insert 하기 , 오류를 일부러 내기 위해 guest 먼저-->
		<!--guest02 -->
		<div>
			<label for="sub">sub</label>
			<input type="text" name="sub" id="sub">
		</div>
		<div>
			<label for="unum">unum</label>
			<input type="text" name="unum" id="unum">
		</div>
		<div>
			<label for="pay">pay</label>
			<input type="text" name="pay" id="pay">
		</div>

		<!--user02 -->
		<div>
			<label for="id">id</label>
			<input type="text" name="id" id="id">
		</div>
		<div>
			<label for="pw">pw</label>
			<input type="text" name="pw" id="pw">
		</div>
		<div>
			<label for="name">name</label>
			<input type="text" name="name" id="name">
		</div>

		<div>
			<button>입력</button>
		</div>
	</form>
</body>

</html>
