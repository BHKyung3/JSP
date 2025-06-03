<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 관리</title>
<script type="text/javascript" src="script/member.js"></script>
</head>
<body>
	<h2>회원 수정</h2>
	<form method="post" action="memberUpdate.do" name="frm">
		<table>
			<tr> <!-- readonly 수정 불가라는 의미 -->
				<td>이름</td>
				<td><input type ="text" name ="name" size ="20"
				value="${mVO.name}"></td>
			</tr>
			<tr>
				<td>아이디</td>
				<td>
					<input type ="text" name ="userid" size ="20"
					value="${mVO.userid}" readonly>
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
				<td><input type ="text" name ="email" size ="20"
				value="${mVO.email}"></td>
			</tr>
			<tr>
				<td>전화번호</td>
				<td><input type ="text" name ="phone" size ="20"
				value="${mVO.phone}"></td>
			</tr>
			<tr>
				<td>등급</td>
				<td>
					<c:if test="${mVO.admin==0}">
						<input type ="radio" name ="admin" value ="1">관리자
						<input type ="radio" name ="admin" value ="0" checked="checked">일반회원
					</c:if>
					<c:if test="${mVO.admin==1}">
						<input type ="radio" name ="admin" value ="1">관리자
						<input type ="radio" name ="admin" value ="0" checked="checked">일반회원
					</c:if>
				</td>
			</tr>
			<tr>
				<td colspan ="2" align="center";><br>
					<input type ="submit" value ="수정" onclick="return joinCheck()">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type ="reset" value ="취소">
				</td>
			</tr>
			<tr>
		</table>
	</form>
</body>
</html>