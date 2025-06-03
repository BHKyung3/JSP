<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
// 	이 3가지는 반드시 기재해야하는 항목으로 처음부터 기재해둬야 함
	Connection conn = null; // DB와 연결하는 객체
	Statement stmt = null; // SQL(오라클) 문장을 실행하는 객체
	ResultSet rs = null; // SQL 결과를 저장하는 객체
	
	String url = "jdbc:oracle:thin:@localhost:49161:xe";
	// String uid = "scott"; // 오라클에 있는 정보
	String uid = "system";// mysql 있는 정보
	String pass = "oracle"; // 오라클에 있는 정보
	String sql = "select * from employee"; // 오라클에 있는 정보
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table width = "800" border = "1">
		<tr>
			<th>이름</th><th>주소</th><th>주민번호</th>
		</tr>
		<%
			try { // try => 예외가 발생할 수 있는 위험한 코드를 감싼다
				// 1. 드라이브 로드(객체생성)
				Class.forName("oracle.jdbc.driver.OracleDriver"); // 요거 미기재 시 동작하지 않음
				// 2. DB 연결
				conn = DriverManager.getConnection(url, uid, pass);
				// 3. SQL 구문 전송
				stmt = conn.createStatement();
				// 4. SQL 실행()
				rs = stmt.executeQuery(sql);
				
				// 결과 출력
				while(rs.next()) { // 가져올 데이터가 있는가?
					out.println("<tr>");
					out.println("<td>" + rs.getString("name") + "</td>");
					out.println("<td>" + rs.getString("address") + "</td>");
					out.println("<td>" + rs.getString("ssn") + "</td>");
					out.println("</tr>");
				} // 데이터 가져오기가 다 끝날 때까지 반복
				// out.println(conn);
			} catch(Exception e) { // catch => try 안에서 예외가 발생했을 때 잡아서 처리하는 부분
			}finally { // 연결 끊기 finally => catch 공간에서 오류가 발생되도 무조건 실행됨
			} try {
				if(rs!= null) rs.close(); // 연결이 되지 않았을 때 어떻게 할껀데 => rs가 열려 있지 않다면 그래도 닫아라
				if(stmt!= null) stmt.close();
				if(conn!= null) conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		%>
	</table>
</body>
</html>