<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/resource/user/modify.css">
<title>정보수정</title>
</head>
<body>
	<!-- pw birth age name 수정 -->
<div class="container">
	<form action="/ucl/edit" method="post">
	
	<input type="hidden" name="id" value="${ses.id }">
		
		<div class="form-group">
            <label for="id">아이디 :</label> 
		<input type="text" disabled="disabled" name="id" value="${ses.id }"> <br> <br> <hr>
		</div>
		<div class="form-group">
            <label for="pw">비밀번호 :</label> 
		<input type="password" name="pw" value="${ses.pw }"> <br> <br> <hr>
		</div>
		<div class="form-group">
            <label for="birth">생년월일 :</label> 
		<input type="text" name="birth" value="${ses.birth }"> <br> <br> <hr>
		</div>
		<div class="form-group">
            <label for="age">나이 :</label> 
		<input type="text" name="age" value="${ses.age }"> <br> <br> <hr>
		</div>
		<div class="form-group">
            <label for="name">이름 :</label> 
		<input type="text" name="name" value="${ses.name }"> <br> <br> <hr>
		</div>
		<div class="button-wrapper">
		<button type="submit">수정</button>
		</div>
	</form>
	 <br> <br> <hr>
	 <form action="/ucl/remove">
	 	<input type="hidden" name="id" value="${ses.id }">
	 	<div class="button-wrapper">
	 	<button type="submit">회원탈퇴</button>
	 	</div>
	 </form>
</div>
</body>
</html>