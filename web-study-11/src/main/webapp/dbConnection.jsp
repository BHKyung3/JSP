
<!-- DB 연동이 정상적으로 되었는지 확인하는 곳 -->

<%@page import="java.sql.Connection"%>
<%@page import="ntil.DBManger"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% 
	// DB 연동이 정상적으로 됬는지 확인하는 방법(또는 <body> 안에 conn : <%= DBManger.getconnConnection() 기재하여 확인 가능)
	Connection conn = DBManger.getConnection();
	out.println("conn : " + conn);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>