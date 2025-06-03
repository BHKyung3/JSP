
<!--  이 idCheck.jsp 파일은 아이디 중복 확인 결과를 보여주는 JSP 페이지야. 보통 회원가입할 때 아이디 중복확인 버튼을 누르면 새 창(Popup) 으로 열려서 이 페이지가 실행 -->

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <!-- JSP 선언부 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="script/member.js"></script>
</head>
<body>
	<h2>아이디 중복 체크</h2>
	<form action="idCheck.do" method="get" name="frm"> 
	
		<!-- 사용자 입력란 -->
		아이디 <input type="text" name="userid" value=${userid}>
			<input type="submit" value="중복체크">
		<br>
		<!-- 중복 체크 결과 출력 (조건문) -->
		<c:if test="${result == 1}">
			<script type="text/javascript">
				opener.document.frm.userid.value="";
			</script>
			${userid}는 이미 사용 중인 아이디입니다.
		</c:if>
		<c:if test="${result == -1}">
			${userid}는 사용 가능한 아이디입니다.
			<input type="button" value="사용" class="cancel" onclick="idok()">
		</c:if>
	</form>
</body>
</html>