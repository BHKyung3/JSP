
<!-- 이 코드는 회원가입 폼을 보여주는 JSP 페이지야. 사용자가 이름, 아이디, 비밀번호, 이메일, 전화번호, 등급 등을 입력하고 제출하면, 해당 정보가 join.do 서블릿으로 전달돼 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입</title>
<script type="text/javascript" src="script/member.js"></script> <!-- HTML + JavaScript 연동 -->
</head>
<body>
	<h2>회원 가입</h2>
	'*' 표시 항목은 필수 입력 항목입니다.
	<form method="post" action="join.do" name="frm">
		<table>
			<tr>
				<td>이름</td>
				<td><input type ="text" name ="name" size ="20">*</td>
			</tr>
			<tr>
				<td>아이디</td>
				<td>
					<input type ="text" name ="userid" size ="20" id ="userid">*
					<input type ="hidden" name ="reid" size ="20">
					<input type ="button" value ="중복 체크" onclick="idCheck()">
				</td>
			</tr>
			<tr>
				<td>암  호</td>
				<td><input type ="password" name ="pwd" size ="20">*</td>
			</tr>
			<tr height = "30">
				<td width="80">암호 확인</td>
				<td><input type="password" name="pwd_check" size="20">*</td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><input type ="text" name ="email" size ="20"></td>
			</tr>
			<tr>
				<td>전화번호</td>
				<td><input type ="text" name ="phone" size ="20"></td>
			</tr>
			<tr>
				<td>등급</td>
				<td>
					<input type ="radio" name ="admin" value ="1">관리자
					<input type ="radio" name ="admin" value ="0" checked="checked">일반회원
				</td>
			</tr>
			<tr>
				<td colspan ="2" align="center";><br>
					<input type ="submit" value ="확인" onclick="return joinCheck()">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type ="reset" value ="취소">
				</td>
			</tr>
			<tr>
				<td colspan="2">${message}</td>
		</table>
	</form>
</body>
</html>