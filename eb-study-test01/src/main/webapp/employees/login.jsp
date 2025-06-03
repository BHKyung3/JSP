<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>
<script type="text/javascript" src="script/member.js"></script> <!-- 유효성 검사 -->
<style>
	table {margin: 0 auto; padding: 0; box-sizing: border-box;
			border-collapse: collapse;
            width: 80%;
            table-layout: fixed; text-align: center;
            margin: 30px auto;}
</style>
</head>
<body>
<form action="login.do" method="post">
	<table border="1" style="text-align:center;">
		<td></td>
		<td></td>
		<td>로그인</td>
		<td>사원 등록<br>(관리자로 로그인 후 사용 가능)</td>
		<td>마이페이지</td>
	</table>
    <table border="1">
        <tr>
            <td colspan="2" style="text-align:center; font-weight:bold;">로그인</td>
        </tr>
        <tr>
            <td>아이디</td>
            <td><input type="text" name="id" value="${id}"></td>
        </tr>
        <tr>
            <td>비밀번호</td>
            <td><input type="password" name="pass"></td>
        </tr>
        <tr>
            <td>레벨</td>
            <td>
                <select name="lev">
                    <option value="A">운영자</option>
                    <option value="B" selected>일반회원</option>
                </select>
            </td>
        </tr>
        <tr>
            <td colspan="2" style="text-align:center;">
                <input class="btn" type="submit" value="로그인" 
                onclick="return loginCheck()">
                <input class="btn" type="reset" value="취소">
            </td>
        </tr>
    </table>
        <tr>
			<td colspan="2">${message}</td>
		</tr>
</form>
</body>
</html>