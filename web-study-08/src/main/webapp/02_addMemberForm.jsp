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
				<td>아이디</td>
				<td><input type = "text" name = "userid" size = "20"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type = "password" name = "pwd" size = "20"></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><input type = "email" name = "email" size = "20"></td>
			</tr>
			<tr>
				<td>전화번호</td>
				<td><input type = "text" name = "phone" size = "20"></td>
			</tr>
			<tr>
				<td>등급</td>
				<td>
					<input type = "radio" name = "admin" value = "1">관리자
					<input type = "radio" name = "admin" value = "0" checked="checked">일반회원
				</td>
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