<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.net.ConnectException"%>
<%@page import="java.sql.Connection"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://fonts.googleapis.com/css2?family=Nanum+Pen+Script&display=swap" rel="stylesheet">

<style>
        body {
            background-color: #fffde7;
            font-family: 'Nanum Pen Script', cursive;
            text-align: center;
            padding-top: 100px;
        }
        .success-box {
            background-color: #fff8c6;
            display: inline-block;
            padding: 40px 60px;
            border-radius: 20px;
            box-shadow: 0px 4px 10px rgba(0,0,0,0.1);
        }
        h3 {
            font-size: 60px;
            color: #444;
            margin-bottom: 30px;
        }
        a {
            text-decoration: none;
            color: #6a1b9a;
            font-weight: bold;
            font-size: 40px;
            border-bottom: 2px solid #6a1b9a;
            transition: all 0.3s ease;
        }
        a:hover {
            color: #4a148c;
            border-color: #4a148c;
        }
    </style>
</head>
<body>
	<%
	request.setCharacterEncoding("UTF-8");

	Connection conn = null;
	PreparedStatement pstmt = null;
	
	String url = "jdbc:oracle:thin:@localhost:49161:xe";
	String uid = "scott";
	String pass = "1234";
	
	String sql = "insert into member values(?, ?, ?, ?, ?, ?)"; // member values 테이블 갯수에 맞춰 기재 필요
	
	String name = request.getParameter("name");
	String userid = request.getParameter("userid");
	String pwd = request.getParameter("pwd");
	String email = request.getParameter("email");
	String phone = request.getParameter("phone");
	int admin = Integer.parseInt(request.getParameter("admin"));

	
	try {
	// 1. 드라이브 로드
	Class.forName("oracle.jdbc.driver.OracleDriver");
	// 2. DB 연결
	conn = DriverManager.getConnection(url, uid, pass);
	// 3. prepareStatement 객체 생성 -> SQL문을 미리 컴파일해 놓고, 나중에 값만 변경해서 실행한다
	pstmt = conn.prepareStatement(sql);
	// 4. 값 바인딩 변수를 채운다
	pstmt.setString(1, name);
	pstmt.setString(2, userid);
	pstmt.setString(3, pwd);
	pstmt.setString(4, email);
	pstmt.setString(5, phone);
	pstmt.setInt(6, admin);
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