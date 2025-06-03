
<!-- 사이트의 시작점 역할을 하며, 자동으로 로그인 페이지로 이동시키는 역할을 해. -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- <a href="login.do">로그인 페이지로 이동</a> => 링크를 클릭해야 로그인 화면으로 이동 방식 -->
	<script type="text/javascript">window.location.href="BoardServlet?command=board_list";</script>
	<!-- ↑ 사용자가 직접 index.jsp를 열면 바로 로그인 페이지로 이동시켜주는 역할 -->
</body>
</html>