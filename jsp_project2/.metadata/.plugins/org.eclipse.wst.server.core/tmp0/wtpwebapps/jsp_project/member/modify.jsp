<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 수정</title>
<style type="text/css">
body {
	text-align: center;
}
</style>
</head>
<body>
	<h1>회 원 정 보 수 정</h1>
	
	<form action="/mem/edit" method="post">
	 <input type="hidden" name="id" value="${ses.id }">
		아이디 : <input type="text" disabled="disabled" name="id" value="${ses.id }"> <br> <br>
									<!-- readonly="readonly"로 사용해도됨 -->
		비밀번호 : <input type="password" name="pw" value="${ses.pw }"> <br> <br>
		이메일 : <input type="email" name="email" value="${ses.email }"> <br> <br>
		나이 : <input type="text" name="age" value="${ses.age }"> <br>
		<br>
		<hr>
		<button type="submit">수 정 완 료</button>
		<!-- 
			<button type="submit">회 원 탈 퇴</button>
		 -->
	</form>
	<br>
	<form action="/mem/remove" method="post">
		<input type="hidden" name="id" value="${ses.id }" >
		<button type="submit">회 원 탈 퇴</button>
	</form>
</body>
</html>