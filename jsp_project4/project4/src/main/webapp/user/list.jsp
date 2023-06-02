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
<title>회원목록</title>
<style type="text/css">
body {
	text-align: center;
}
</style>
</head>
<body>
<!-- id pw birth age reg_date name -->
 <table class="table table-striped">
 	<thead>
 		<tr>
 			<th>아이디</th>
 			<th>비밀번호</th>
 			<th>생년월일</th>
 			<th>나이</th>
 			<th>생성일</th>
 			<th>이름</th>
 		</tr>
 	</thead>
 	<tbody>
 		<c:forEach items="${list }" var="uvo">
 			<tr>
 				<td>${uvo.id }</td>
 				<td>${uvo.pw }</td>
 				<td>${uvo.birth }</td>
 				<td>${uvo.age }</td>
 				<td>${uvo.reg_date }</td>
 				<td>${uvo.name }</td>
 			</tr> 		
 		</c:forEach>
 	</tbody>
 </table>
 <br> <br> <br> <hr>
 <a href="/"> <button type="button">처음으로</button> </a>
</body>
</html>