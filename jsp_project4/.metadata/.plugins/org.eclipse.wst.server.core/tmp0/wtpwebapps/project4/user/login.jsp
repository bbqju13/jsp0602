<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/resource/user/login.css">
<title>로그인</title>
</head>
<body>
	<div class="container">
		<form action="/ucl/login_auth" method="post">
		<div class="form-group">
			<input type="text" name="id" placeholder="아이디" class="in"> <br>
		</div>
		<div class="form-group">
			<input type="password" name="pw" placeholder="비밀번호" class="in"> <br>
		</div>
			<div class="button-wrapper">
				<button type="submit" id="asd" value="로그인">로그인</button>
			</div>
		</form>
		<div class="link-wrapper">
			<a href="/">비밀번호를 잊어버리셨나요?</a>
		</div>
	</div>
</body>
</html>