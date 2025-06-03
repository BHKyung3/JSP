<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		int num1 = 20;
		int num2 = 10;
		
		int add = num1 + num2;
		out.print(num1 + " + " + num2 + " = " + add);
		// PrintWriter out = response.getWriter(); 없이 out.print 기재해도 오류가 뜨지 않는 이유 :
			// => JSP 내장 객체인 out(JspWriter)이 자동으로 제공되기 때문
	%>
</body>
</html>