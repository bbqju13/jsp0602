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
<title>전체 글목록</title>
</head>
<body>
	<h1>전 체 글 목 록</h1>
	<br>
	<br>
	<hr>
					<!-- 검색라인 -->
	<h3>----------검색 라인--------</h3>
	<form action="/brd/page" method="post">
		<div>
			<c:set value="${pgh.pgvo.type }" var="typed"></c:set>
				<select name="type">
				<!-- selected : 현재 내가 선택한 값 -->
					<option ${typed == null ? 'selected':'' }>선택 ?</option>
					<option value="t" ${typed eq 't' ? 'selected' : '' }>제목</option>
					<option value="c" ${typed eq 'c' ? 'selected' : '' }>내용</option>
					<option value="w" ${typed eq 'w' ? 'selected' : '' }>작성자</option>
					<option value="tc" ${typed eq 'tc' ? 'selected' : '' }>제목 / 내용</option>
					<option value="tw" ${typed eq 'tw' ? 'selected' : '' }>제목 / 작성자</option>
					<option value="cw" ${typed eq 'cw' ? 'selected' : '' }>내용 / 작성자</option>
				</select>
			<input type="text" name="keyword" placeholder="검색">		
			<input type="hidden" name="pageNo" value="${pgh.pgvo.pageNo }">
			<input type="hidden" name="qty" value="${pgh.pgvo.qty }">
			<button type="submit">검색</button>	
		</div>
	</form>
	
	<h3>-----------------------------</h3>
	<table class="table table-striped">
	<!-- 검색라인 -->
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>글쓴이</th>
				<th>등록날짜</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list }" var="bvo">
				<tr>
					<td><a href="/brd/detail?bno=${bvo.bno }"> ${bvo.bno } </a></td>
					<td>
					<c:if test="${bvo.image_file ne null }">
						<img alt="XXX" src="/_fileupload/TH_${bvo.image_file }">
					</c:if>
					${bvo.title }
					</td>
					<td>${bvo.writer }</td>
					<td>${bvo.reg_date }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="/">
		<button type="button">처음으로</button>
	</a>
	
	<h3>-------------페이지네이션위치-------------</h3>
		
	<c:if test="${pgh.prev }">
		<a href="/brd/page?pageNo=${pgh.startPage - 1 }&qty=${pgh.pgvo.qty}&type=${pgh.pgvo.type }&keyword=${pgh.pgvo.keyword}"> ◀이전 </a>
	</c:if>

	<c:forEach begin="${pgh.startPage }" end="${pgh.endPage }" var="i">
		<a href="/brd/page?pageNo=${i }&qty=${pgh.pgvo.qty}&type=${pgh.pgvo.type }&keyword=${pgh.pgvo.keyword}"> ${i } | </a>
	</c:forEach>

	<!-- 다음페이지 -->
	<c:if test="${pgh.next }">
		<a href="/brd/page?pageNo=${pgh.endPage +1 }&qty=${pgh.pgvo.qty}&type=${pgh.pgvo.type }&keyword=${pgh.pgvo.keyword}"> 다음▶ </a>
	</c:if>
</body>
</html>