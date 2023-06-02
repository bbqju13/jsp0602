<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 작성</title>
</head>
<body>
	<h1>게시글 작성 페이지</h1>
	
	<form action="/brd/insert" method="post" enctype="multipart/form-data">
		제목 :  <input type="text" name="title"> <br> <br>
		글쓴이 : <input type="text" name="writer" value="${ses.id }" readonly="readonly"> <br> <br>
		내용 : <textarea rows="5" cols="30" name="content"></textarea> <br> <br>
		이미지 파일 : <input type="file" id="file" name="image_file" accept="image/png, image/jpg, image/jpeg, image/bmp, image/gif, image/webp">
		<br> <br> <hr>
		<button type="submit">등 록</button>
	</form>
</body>
</html>