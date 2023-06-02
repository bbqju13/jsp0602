<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글수정 페이지</title>
</head>
<body>
	<h1>글 수 정 페 이 지</h1>
	<form action="/brd/edit" method="post" enctype="multipart/form-data">
			
		<input type="hidden" name="bno" value="${bvo.bno }">
		제목 : <input type="text" name="title" value="${bvo.title }"> <br> <br>
		이름 : <input type="text" name="writer" value="${bvo.writer }"> <br> <br>
		내용 : <textarea rows="5" cols="30" name="content">${bvo.content }</textarea> <br> <br>
		등록일 : ${bvo.reg_date } <br> <br>
		이미지 파일 : <img alt="XXX" src="/_fileupload/TH_${bvo.image_file }">
		<input type="hidden" name="image_file" value="${bvo.image_file }">
		<input type="file" name="new_file"> 
			<br> <br> <hr>
		<button type="submit">완료</button>
	</form>
	 
		<a href="/brd/remove?bno=${bvo.bno }"> <button type="button">삭제</button> </a>
	 
</body>
</html>