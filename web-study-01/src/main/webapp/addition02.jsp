<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		int num1 =20;
		int num2 = 10;
		int add = num1 + num2;
	%>
	<h1>더하기 하기</h1>
	<%= num1 %> + <%= num2 %> = <%= add %>
</body>
</html>