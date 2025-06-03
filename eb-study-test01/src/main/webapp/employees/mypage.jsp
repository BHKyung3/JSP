<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
<script type="text/javascript" src="script/member.js"></script>
<style>
	table {margin: 0 auto; padding: 0; box-sizing: border-box;
			border-collapse: collapse;
            width: 80%;
            table-layout: fixed; text-align: center;
            margin: 30px auto;}
</style>
</head>
<body>
<form action="mypage.do" method="post">
	<table border="1" style="text-align:center;">
		<td>${loginUser.name}님 반갑습니다.</td>
		<td>레벨 : ${loginUser.lev}</td>
		<td>
			<a href="logout.do">로그아웃</a>
		</td>
		<td>
            <c:if test="${loginUser.lev=='A'}">
               <a href='join.do'>사원 등록</a>
            </c:if>
            <c:if test="${loginUser.lev=='B'}">
               사원 등록<br>(관리자로 로그인 후 사용 가능)
            </c:if>
         </td>
		<td>
			<a href="mypage.do?id=${loginUser.id}">마이페이지</a>
		</td>
	</table>
	<table border="1">
        <tr>
            <td colspan="2" style="text-align:center; font-weight:bold;">마이페이지</td>
        </tr>
        <tr>
			<td>아이디</td>
			<td>
				<input type ="text" name ="id" size ="20"
				value="${eVO.id}" readonly>
			</td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td>
			<input type ="password" name ="pass" size ="20"
			value="${eVO.id}"></td>
		</tr>
		<tr>
			<td>이름</td>
			<td><input type ="text" name ="name" size ="20"
			value="${eVO.name}"></td>
		</tr>
		<tr>
			<td>권한</td>
			<td>
				<input type ="radio" name ="lev" value ="A">운영자
				<input type ="radio" name ="lev" value ="B" checked="checked">일반회원
			</td>
		</tr>
		<tr>
			<td>성별</td>
			<td>
				<input type ="radio" name ="gender" value ="1">남자
				<input type ="radio" name ="gender" value ="2" checked="checked">여자
			</td>
		</tr>
		<tr>
			<td>전화번호</td>
			<td>
			<input type ="text" name ="phone" size ="20"
			value="${eVO.phone}"></td>
		</tr>
		<tr>
			<td colspan ="2" align="center"><br>
				<input type ="submit" value ="수정" onclick="return joinCheck()">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type ="reset" value ="취소">
			</td>
		</tr>
	</table>
</form>
</body>
</html>