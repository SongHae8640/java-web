<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
</head>

<body>
	<h1>file upload</h1>
	<!-- 파일 업로드는 method가 post방식, enctype은 multipart/form-data 여야한다. -->
	<form action="upload.bit" method="post" enctype="multipart/form-data">
		<div>
			<label for="id">id</label>
			<input type="text" name="id" id="id">
		</div>
		<div>
			<input type="file" name="myFile">
		</div>
		<div>
			<button type="submit">submit</button>
		</div>
		
	</form>
</body>

</html>
