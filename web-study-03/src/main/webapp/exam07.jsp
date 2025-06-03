<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 조건문, 반복문 안에는 자바코드만 기재 가능하며 HTML코드는 기재할 수 없다.
	 HTML을 기재하려면 자바코드에 맞춰 끊고 다시 시작하는 아래와 같은 형식을 반복해야한다 -->
	<%
		int number = 70;
	
		if(number>=90){
	%>
			<h1>A</h1>
	<% 
		} else if(number>=80){
	%>
			<h1>B</h1>
	<%
		} else{
	%>
			<h1>C</h1>
	<%
		}
	%>
</body>
</html>