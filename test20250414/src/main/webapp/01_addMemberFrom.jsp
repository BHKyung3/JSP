<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>회원 가입을 위한 정보를 입력하세요.</h2>
	
	<form method="post" action="01_allMember.jsp">
		<table>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name" size="20"></td>
			</tr>
			<tr>
				<td>아이디</td>
				<td><input type="text" name="userid" size="20"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="text" name="pwd" size="20"></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><input type="text" name="email" size="20"></td>
			</tr>
			<tr>
				<td>연락처</td>
				<td><input type="text" name="phone" size="20"></td>
			</tr>
			<tr>
				<td>주소</td>
				<td><input type="text" name="address" size="20"></td>
			</tr>
			<tr>
				<td colspan = "2" style = "text-align: center;"><br>
					<input type = "submit" value = "회원가입">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type = "reset" value = "취소">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>