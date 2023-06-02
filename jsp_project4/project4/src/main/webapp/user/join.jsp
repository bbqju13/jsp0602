<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/resource/user/join.css">
<title>회원가입</title>
</head>
<body>
	<!-- id pw birth age name -->
<div class="container">
	<form action="/ucl/register" method="post">
		<div class="form-group">
            <label for="id">아이디 :</label> 
		<input type="text" name="id" placeholder="아이디"> <br> <br> <hr>
		</div>
		<div class="form-group">
            <label for="pw">비밀번호 :</label> 
		<input type="password" name="pw" placeholder="비밀번호"> <br> <br> <hr>
		</div>
		<div class="form-group">
            <label for="birth">생년월일 :</label> 
		<input type="text" name="birth" placeholder="생년월일"> <br> <br> <hr>
		</div>
		<div class="form-group">
            <label for="age">나이 :</label> 
		<input type="text" name="age"> <br> <br> <hr>
		</div>
		<div class="form-group">
            <label for="name">이름 :</label> 
		<input type="text" name="name"> <br> <br> <hr>
		</div>
		<div class="button-wrapper">
			<button type="submit">회원가입</button>
		</div>
	</form>
</div>
</body>
</html>