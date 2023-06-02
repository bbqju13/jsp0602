<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
	crossorigin="anonymous"></script>
<title>회원 리스트</title>
</head>
<body>
	<h1>회 원 리 스 트</h1>
	<br> <br> <hr>
	<table class="table table-striped">
		<thead>
			<tr>
				<th>아이디</th>
				<th>이메일</th>
				<th>나이</th>
				<th>회원가입날짜</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list }" var="mvo">
				<tr>
					<td>${mvo.id }</td>
					<td>${mvo.email }</td>
					<td>${mvo.age }</td>
					<td>${mvo.reg_date }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<br>
	<br>
	<hr>
	<br>
	<a href="/">
		<button type="button">처음화면</button>
	</a>
</body>
</html>