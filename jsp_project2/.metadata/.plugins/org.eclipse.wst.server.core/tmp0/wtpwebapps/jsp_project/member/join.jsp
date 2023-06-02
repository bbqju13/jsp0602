<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 페이지</title>
<style type="text/css">
body {
	text-align: center;
}
</style>
</head>
<body>

	<h1>회원가입 페이지</h1>

	<form action="/mem/register" method="post">

		아이디 : <input type="text" name="id" placeholder="아이디"> <br>
		비밀번호 : <input type="password" name="pw" placeholder="비밀번호"> <br>
		이메일 : <input type="text" name="email" placeholder="email@a123.com"> <br>
		나이 : <input type="text" name="age"> <br> 
		<br>
		<button type="submit">가입완료</button>

	</form>
</body>
</html>