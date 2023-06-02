<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/resource/table/register.css">
<title>글작성</title>
</head>
<body>
<div class="container">
	<form action="/tcl/insert" method="post" enctype="multipart/form-data">
	<div class="form-group">
		제목 : <input type="text" name="title"> <br> <br> <br> <hr>
	</div>
	<div class="form-group">
		작성자 : <input type="text" name="writer" value="${ses.id }" readonly="readonly"> <br> <br> <br> <hr>
	</div>
	<div class="form-group">
		내용 : <textarea rows="5" cols="30" name="content"></textarea> <br> <br> <br> <hr>
	</div>
	<div class="form-group">
		이미지 파일 : <input type="file" id="file" name="img_file"> <br> <br> <br> <hr>
	</div>
		<div class="button-wrapper">
			<button type="submit">등록</button>
		</div>
	</form>
</div>
</body>
</html>