<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.net.ConnectException"%>
<%@page import="java.sql.Connection"%>

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
	request.setCharacterEncoding("UTF-8");

	Connection conn = null;
	PreparedStatement pstmt = null;
	
	String url = "jdbc:oracle:thin:@localhost:49161:xe";
	String uid = "system";
	String pass = "oracle";
	
	String sql = "insert into employee values(?, ?, ?)"; // member values 테이블 갯수에 맞춰 기재 필요
	
	String name = request.getParameter("name");
	String address = request.getParameter("address");
	String ssn = request.getParameter("ssn");
	
	try {
	// 1. 드라이브 로드
	Class.forName("oracle.jdbc.driver.OracleDriver");
	// 2. DB 연결
	conn = DriverManager.getConnection(url, uid, pass);
	// 3. prepareStatement 객체 생성 -> SQL문을 미리 컴파일해 놓고, 나중에 값만 변경해서 실행한다
	pstmt = conn.prepareStatement(sql);
	// 4. 값 바인딩 변수를 채운다
	pstmt.setString(1, name);
	pstmt.setString(2, address);
	pstmt.setString(3, ssn);
	// 5. SQL구분 실행
	pstmt.executeUpdate();
	} catch(Exception e) {
		e.printStackTrace();
	}finally {
		try {
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
		} catch(Exception e) {
			
		}
	}
%>
	<h3>회원 가입 성공</h3>
	<a href = "01_allMember.jsp">회원 전체 목록 보기</a>
</body>
</html>