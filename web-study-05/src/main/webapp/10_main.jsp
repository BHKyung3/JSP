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
		if(session.getAttribute("loginUser") == null) {
			response.sendRedirect("10_loginForm.jsp");
		} else {
	%>
			<%= session.getAttribute("loginUser")%>님 안녕하세요!<br>
			저희 홈페이지를 방문해주셔서 감사합니다!
			
			<form method = "get" action="10_Logout.jsp">
				<input type = "submit" value = "로그아웃">
			</form>
	<%
		}
	%>
</body>
</html>