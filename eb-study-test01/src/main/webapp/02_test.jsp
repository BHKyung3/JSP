<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.magic.dao.EmployeesDAO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	EmployeesDAO mepDao = EmployeesDAO.getInstance();

	Connection conn = mepDao.getConnection();
	out.println(conn + "<br>");
	out.println("DB 연결 성공");

%>
</body>
</html>