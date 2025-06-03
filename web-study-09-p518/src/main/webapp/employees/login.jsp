<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="script/employees.js"></script>
</head>
<body>
	<form action="login.do" method="post" name="frm" style="text-align: center;">
		<table border=1 solid; width=100%>
			<tr>
				<td width=20%></td>
				<td width=20%></td>
				<td width=20%>로그인</td>
				<td width=20%>사원 등록<br>(관리자로 로그인 후 사용 가능)</td>
				<td width=20%>마이페이지<br>(로그인 후 사용 가능)</td>
			</tr>
		</table>
		<table style="margin: 0 auto;" border=1px solid black; width=50%;>
			<tr>
				<td colspan="2">로그인</td>
			</tr>
			<tr>
				<td>아이디 </td>
				<td><input type="text" name="id" value="${id}"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="pass"></td>
			</tr>
			<tr>
				<td>레벨</td>
				<td>
					<select id="lev" name="lev">
						<option value="A">운영자</option>
						<option value="B" selected>일반 회원</option>
					</select>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="로그인" onclick="return loginCheck()">&nbsp;&nbsp;
					<input type="reset" value="취소">&nbsp;&nbsp;
				</td>
			</tr>
		</table>
		<table><tr><td colspan="2" >${message}</td></tr></table>
	</form>
</body>
</html>