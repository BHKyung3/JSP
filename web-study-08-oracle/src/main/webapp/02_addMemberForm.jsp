<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>회원의 정보 입력 폼</h2>
	
	<form method="post" action="02_addMember.jsp">
		<table>
			<tr>
				<td>이름</td>
				<td><input type = "text" name = "name" size = "20"></td>
			</tr>
			<tr>
				<td>주소</td>
				<td><input type = "text" name = "address" size = "20"></td>
			</tr>
			<tr>
				<td>주민번호</td>
				<td><input type = "text" name = "ssn" size = "20"></td>
			</tr>
			<tr>
				<td colspan = "2" style = "text-align: center;"><br>
					<input type = "submit" value = "전송">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type = "reset" value = "취소">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>