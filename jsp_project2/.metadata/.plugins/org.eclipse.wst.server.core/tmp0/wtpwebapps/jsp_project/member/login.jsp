<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>
<style type="text/css">
body {
	text-align: center;
}
</style>
</head>
<body>
	<h1>
		로그인 페이지
	</h1>
	
	<form action="/mem/login_auth" method="post">
		아이디 : <input type="text" name="id"> <br> <br>
		비밀번호 : <input type="password" name="pw"> <br>
		<br>
		<button type="submit">로그인</button>
	</form>
</body>
</html>