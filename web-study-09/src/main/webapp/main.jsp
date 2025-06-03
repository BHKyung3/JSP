<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${empty loginUser}"> <!-- loginUser 객체가 없으면(즉, 로그인하지 않은 상태) 로그인 페이지로 자동 리다이렉트 시켜줌. -->
	<%-- <jsp:forward page="login.do"></jsp:forward> --%>
	<script type="text/javascript">
		window.location.href="login.do";
	</script>
</c:if>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 관리</title>
</head>
<body>
	<h2>회원 전용 페이지</h2>
	<form action="logout.do">
		<table>
			<tr>
				<td>안녕하세요. ${loginUser.name}( ${loginUser.userid} )님</td> <!-- 로그인한 회원의 이름과 아이디를 출력 -->
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="로그아웃">&nbsp;&nbsp;
					<input type="button" value="회원정보변경"
						onclick = "location.href='memberUpdate.do?userid=${loginUser.userid}'">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>