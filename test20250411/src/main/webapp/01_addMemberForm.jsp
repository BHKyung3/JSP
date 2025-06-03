<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://fonts.googleapis.com/css2?family=Nanum+Pen+Script&display=swap" rel="stylesheet">
<style>
    h3 {
        text-align: center;
        background-color: #fff99d;
        padding: 15px;
        border-radius: 20px;
        margin-bottom: 25px;
        font-size: 24px;
        color: #444;
    }
    body {
        font-family: 'Nanum Pen Script', cursive;
        background: linear-gradient(to bottom, #fff6b7, #fef9e7);
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        margin: 0;
    }

    .form-wrapper {
        background-color: #fffefc;
        border-radius: 25px;
        box-shadow: 0 10px 30px rgba(0, 0, 0, 0.1);
        padding: 30px 40px;
        width: 400px;
    }


    table {
        width: 100%;
    }

    td {
        padding: 10px 5px;
        font-size: 18px;
    }

    input[type="text"],
    input[type="password"],
    input[type="email"] {
        width: 95%;
        padding: 8px 12px;
        border-radius: 15px;
        border: 1px solid #ccc;
        background-color: #f8fcff;
        font-size: 16px;
    }

    input[type="radio"] {
        margin-right: 5px;
    }

    input[type="submit"],
    input[type="reset"] {
        padding: 10px 20px;
        font-size: 18px;
        border-radius: 15px;
        border: none;
        cursor: pointer;
        margin: 0 10px;
        transition: background-color 0.3s ease;
    }

    input[type="submit"] {
        background-color: #a5d8ff;
        color: #333;
    }

    input[type="submit"]:hover {
        background-color: #87c6f4;
    }

    input[type="reset"] {
        background-color: #ffc5c5;
        color: #333;
    }

    input[type="reset"]:hover {
        background-color: #ff9f9f;
    }

    .btn-group {
        text-align: center;
        margin-top: 20px;
    }
</style>

</head>
<body>
	<form method="post" action="01_addMember.jsp">
	
	<h3>회원가입을 위한 정보를 입력해주세요!</h3>
		<table>
			<tr>
				<td>이름</td>
				<td><input type = "text" name = "name" size = "20"></td><br>
			</tr>
			<tr>
				<td>아이디</td>
				<td><input type = "text" name = "userid" size = "20"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type = "password" name = "pwd" size = "20"></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><input type = "email" name = "email" size = "20"></td>
			</tr>
			<tr>
				<td>전화번호</td>
				<td><input type = "text" name = "phone" size = "20"></td>
			</tr>
			<tr>
				<td>등급</td>
				<td>
					<input type = "radio" name = "admin" value = "1">관리자
					<input type = "radio" name = "admin" value = "0" checked="checked">일반회원
				</td>
			</tr>
			<tr>
				<td colspan = "2" style = "text-align: center;"><br>
					<input type = "submit" value = "전송">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type = "reset" value = "취소">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>