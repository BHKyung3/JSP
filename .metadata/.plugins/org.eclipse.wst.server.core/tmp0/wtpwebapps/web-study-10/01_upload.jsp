<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="upload.do" method="post" enctype="multipart/form-data"> <!-- method : post 방식 사용, get 방식은 용량이 작아 미사용 -->
		글쓴이 : <input type="text" name="name"><br>
		제목 : <input type="text" name="title"><br>
		파일 지정하기 :<input type="file" name="uploadFile"><br> <!-- file : 파일 선택 버튼으로 표시되어 나타냄 -->
		<input type="submit" value="전송"><br>
	</form>
</body>
</html>