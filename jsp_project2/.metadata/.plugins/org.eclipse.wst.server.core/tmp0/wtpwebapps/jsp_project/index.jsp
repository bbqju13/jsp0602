<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index</title>

<style type="text/css">
body {
	text-align: center;
}
</style>

</head>
<body>
	<h1> INDEX PAGE </h1>
	
	<c:if test="${ses.id ne null}">
	
		${ses.id }님이 Login 하였습니다. <br>
		<br>
		${ses.id }님은 ${ses.age } 세 입니다. <br>
		<br>
		계정생성일 : ${ses.reg_date } <br>
		<br>
		마지막 접속일 : ${ses.last_login } <br>
		<br> <hr>
		
		<a href="/mem/modify"> <button>회원 정보 수정</button> </a> <br> <br>
		<a href="/mem/logout"><button>로그아웃</button></a> <br> <br>
		<br>
		<a href="/brd/register"><button>게시글 작성</button></a>
		
	</c:if>
	
	<c:if test="${ses.id eq null }">
		<a href="/mem/login"><button>로그인</button></a> <br> <br> <br>
		<a href="/mem/join"> <button>회원가입</button> </a> <br>  <br> <br>
	</c:if>
	
	<br> <br> <br>
	
		<a href="/brd/page"> <button type="button">전체글보기</button> </a>
	<a href="/mem/list"> <button type="button">회원 리스트 이동</button> </a>
	
</body>
<script type="text/javascript">
	const msg_login = `<c:out value="${msg_login}" />`;
	console.log(msg_login);
	if(msg_login === '0'){
		alert('로그인 정보가 올바르지 않습니다.');
	}
</script>
</html>