<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table width = "800" border = "1">
		<tr>
			<th>이름</th>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이메일</th>
			<th>연락처</th>
			<th>주소</th>
		</tr>
	<%
		try {
			// 1. ëë¼ì´ë¸ ë¡ë(ê°ì²´ìì±)
			Class.forName("oracle.jdbc.driver.OracleDriver"); // 요거 미기재 시 동작하지 않음ì
			// 2. DB ì°ê²°
			conn = DriverManager.getConnection(url, uid, pass);
			// 3. SQL êµ¬ë¬¸ ì ì¡
			stmt = conn.createStatement();
			// 4. SQL ì¤í()
			rs = stmt.executeQuery(sql);
				
			// ê²°ê³¼ ì¶ë ¥
			while(rs.next()) { // ê°ì ¸ì¬ ë°ì´í°ê° ìëê°?
				out.println("<tr>");
				out.println("<td>" + rs.getString("name") + "</td>");
				out.println("<td>" + rs.getString("userid") + "</td>");
				out.println("<td>" + rs.getString("pwd") + "</td>");
				out.println("<td>" + rs.getString("email") + "</td>");
				out.println("<td>" + rs.getString("phone") + "</td>");
				out.println("<td>" + rs.getString("address") + "</td>");
				out.println("</tr>");
			}
			} catch(Exception e) { // catch => try ììì ìì¸ê° ë°ìíì ë ì¡ìì ì²ë¦¬íë ë¶ë¶
			}finally { // ì°ê²° ëê¸° finally => catch ê³µê°ìì ì¤ë¥ê° ë°ìëë ë¬´ì¡°ê±´ ì¤íë¨
				try {
					if(rs!= null) rs.close(); // ì°ê²°ì´ ëì§ ììì ë ì´ë»ê² í ê»ë° => rsê° ì´ë ¤ ìì§ ìë¤ë©´ ê·¸ëë ë«ìë¼
					if(stmt!= null) stmt.close();
					if(conn!= null) conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		%>
	</table>
</body>
</html>