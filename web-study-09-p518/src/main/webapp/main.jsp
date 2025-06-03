<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${empty loginUser}">
	<jsp:forward page="login.do"></jsp:forward>
</c:if>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form style="text-align: center;">
	<table border=1 solid; width=100%>
		<tr>
			<td width=20%>${loginUser.name}님 반갑습니다.</td>
			<td width=20%>레벨 : ${loginUser.lev}</td>
			<td width=20%><a href='logout.do'>로그아웃</a></td>
			
			<td>
				<c:if test="${loginUser.lev=='A'}">
					<a href='custom.do'>사원 등록</a>
				</c:if>
				<c:if test="${loginUser.lev=='B'}">
					사원 등록<br>(관리자로 로그인 후 사용 가능)
				</c:if>
			</td>
			
			
			<td width=20%><a href='mypage.do?id=${loginUser.id}'>마이페이지</a></td>
		</tr>
	</table>
	
		<h1>회원 전용 페이지</h1>
</form>
</body>
</html>

				