<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>서블릿</title>
</head>
<body>
	<form method = "get" action = "RadioServlet">
		<label for = "gender">성별 : </label>
		<input type = "radio" name = "gender" id = "gender" value = "남자" checked>남자
		<input type = "radio" name = "gender" id = "gender" value = "여자" checked>여자<br><br>
		
		<label for = "chk_mail">메일 정보 수신 여부 : </label>
		<input type = "radio" name = "chk_mail" id = "chk_mail" value = "yes" checked>수신
		<input type = "radio" name = "chk_mail" id = "chk_mail" value = "no" checked>거부<br><br>
		
		<label for = "content">간단한 가입 인사를 적어주세요.</label>
		<textarea name = "content" id = "content" rows = "3" cols = "35"></textarea><br><br>
		
		<input type = "submit" value = "전송">
	</form>
</body>
</html>