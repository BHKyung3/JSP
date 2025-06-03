<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>서블릿</title>
</head>
<body>
	<form method = "get" action = "CheckboxServlet">
		<input type = "checkbox" name = "item" value = "신발" checked>신발
		<input type = "checkbox" name = "item" value = "가방" checked>가방
		<input type = "checkbox" name = "item" value = "벨트" checked>벨트<br>
		<input type = "checkbox" name = "item" value = "모자" checked>모자
		<input type = "checkbox" name = "item" value = "시계" checked>시계
		<input type = "checkbox" name = "item" value = "쥬얼리" checked>쥬얼리<br>
		
		<input type = "submit" value = "전송">
	</form>
</body>
</html>