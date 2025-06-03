<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${empty loginUser}"> 
	<script type="text/javascript">
		window.location.href="login.do";
	</script>
</c:if>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 관리</title>
<style>
	table {margin: 0 auto; padding: 0; box-sizing: border-box;
			border-collapse: collapse;
            width: 80%;
            table-layout: fixed; text-align: center;
            margin: 30px auto;}
  	h2 {text-align: center;}
</style>
</head>
<body>
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
	<h2>회원 전용 페이지</h2>
</body>
</html>