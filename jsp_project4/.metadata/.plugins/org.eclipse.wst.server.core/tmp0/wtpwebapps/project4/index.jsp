<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/resource/index/index.css">
<title>index</title>
</head>
<body>
	<div class="container">
		<c:if test="${ses.id ne null }">
			<div class="info-section">
				${ses.id } 님이 로그인 하였습니다. <br> <br>
				<hr>
				${ses.name } 님은 ${ses.age } 세 입니다. <br> <br>
				<hr>
				계정 생성일 : ${ses.reg_date } <br> <br>
				<hr>
				마지막 접속일 : ${ses.last_log } <br> <br>
				<hr>
			</div>

			<a href="/ucl/modify">
				<button>정보수정</button>
			</a>
			<br>
			<br>
			<hr>
			<a href="/ucl/logout">
				<button>로그아웃</button>
			</a>
			<br>
			<br>
			<hr>
			<a href="/tcl/register">
				<button>게시글작성</button>
			</a>
			<br>
			<br>
			<hr>
			<a href="/tcl/page">
				<button>전체글보기</button>
			</a>
			<a href="/ucl/list">
				<button>회원리스트</button>
			</a>
			<hr>
		</c:if>

		<c:if test="${ses.id eq null }">
			<a href="/ucl/login">
				<button>로그인</button>
			</a>
			<br>
			<br>
			<hr>
			<a href="/ucl/join">
				<button>회원가입</button>
			</a>
		</c:if>

		<c:if test="${not empty msg_login}">
			<div class="alert-msg">
				<c:out value="${msg_login}" />
			</div>
		</c:if>
	</div>
	<script type="text/javascript">
		const msg_login = `<c:out value="${msg_login }" />`;
		console.log(msg_login);
		if (msg_login === '0') {
			alert('정보가 올바르지 않습니다.');
		}
	</script>
</body>
</html>