<%@page import="java.net.URLEncoder"%>
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
		String orginId = "test";
		String orginPwd = "1234";
		String nickName = "성윤정";
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		if(orginId.equals(id) && orginPwd.equals(pwd)) {
			// 로그인 성공
			response.sendRedirect("04_main.jsp?name=" + URLEncoder.encode(nickName, "utf-8"));
			// URLEncoder.encode(nickName, "utf-8") => 이름이 한글로 되어 있을 경우 깨지지 않게 함
		} else {
			// 로그인 실패
			response.sendRedirect("04_loginForm.jsp");
		}
		
	%>
</body>
</html>