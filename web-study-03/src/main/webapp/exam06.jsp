<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border = "1">
<!-- for문 안에는 자바코드만 기재 가능하며 HTML코드는 기재할 수 없다.
	 그럼으로 사용하려면 for 사용 문 한 번 끊어주고 코드 기재 후 다시 열고 닫아주어야한다 -->
	<%
		for(int i=0; i<3; i++) { // for문 시작
	%>
		<tr>
			<td>Nunber</td>
			<td><%= i+1 %></td>
		</tr>
	<%
		} // for문 종료
	%>	
	</table>
</body>
</html>