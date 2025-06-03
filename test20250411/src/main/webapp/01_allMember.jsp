<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%!
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	String url = "jdbc:oracle:thin:@localhost:49161:xe";
	String uid = "scott";
	String pass = "1234";
	String sql = "select * from member";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://fonts.googleapis.com/css2?family=Nanum+Pen+Script&display=swap" rel="stylesheet">

<style>
		body {
			background-color: #FFF9DB;
			font-family: 'Malgun Gothic', sans-serif;
			text-align: center;
			padding: 50px;
		}
		h2 {
			color: #444;
			margin-bottom: 30px;
		}
		table {
			margin: 0 auto;
			width: 80%;
			border-collapse: collapse;
			background-color: #fff;
			box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
			border-radius: 10px;
			overflow: hidden;
		}
		th, td {
			border: 1px solid #ddd;
			padding: 12px 15px;
			font-size: 15px;
		}
		th {
			background-color: #FDEFA7;
			color: #333;
		}
		tr:nth-child(even) {
			background-color: #FFFBE3;
		}
		a {
			display: inline-block;
			margin-top: 30px;
			text-decoration: none;
			color: #5e2ca5;
			font-weight: bold;
			border-bottom: 2px solid #5e2ca5;
			padding-bottom: 3px;
		}
	</style>
</head>
<body>
	<table width = "800" border = "1">
		<tr>
			<th>이름</th><th>아이디</th><th>암호</th>
			<th>이메일</th><th>전화번호</th><th>권한(1:관리자, 0:일반회원)</th>
		</tr>
		<%
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				conn = DriverManager.getConnection(url, uid, pass);
				stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);
				
				while(rs.next()) {
					out.println("<tr>");
					out.println("<td>" + rs.getString("name") + "</td>");
					out.println("<td>" + rs.getString("userid") + "</td>");
					out.println("<td>" + rs.getString("pwd") + "</td>");
					out.println("<td>" + rs.getString("email") + "</td>");
					out.println("<td>" + rs.getString("phone") + "</td>");
					out.println("<td>" + rs.getString("admin") + "</td>");
					out.println("</tr>");
				}
			} catch(Exception e) {
			}finally {
			} try {
				if(rs!= null) rs.close();
				if(stmt!= null) stmt.close();
				if(conn!= null) conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		%>
</body>
</html>