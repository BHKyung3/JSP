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
		session.setAttribute("id", "pinksung"); //브라우져 상에 값이 저장됨
		session.setAttribute("pwd", "test1234");
		session.setAttribute("age", 25);
	%>
	
	<h3>세션 설정</h3>
</body>
