<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action "custom.do" method="post" name="frm" style="text-align: center;">
		<table border=1 solid; width=100%>
			<tr>
				<td width=20%>${loginUser.name}님 반갑습니다.</td>
				<td width=20%>레벨 : ${loginUser.lev}</td>
				<td width=20%><a href='logout.do'>로그아웃</a></td>
				<td width=20%><a href='costom.do'>사원 등록</a></td>
				<td width=20%><a href='mypage.do?id=${loginUser.id}'>마이페이지</a></td>
			</tr>
		</table>
		<table style="margin: 0 auto;" border=1px solid black; width=50%;>
			<tr>
				<td>아이디</td>
				<td><input type="text" name="id" id="id"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="pass" id="pass"></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name" id="name"></td>
			</tr>
			<tr>
				<td>권한</td>
				<td>
					<select id="lev" name="lev" id="lev">
						<option value="A">운영자</option>
						<option value="B" selected>일반 회원</option>
					</select>
			</tr>
			<tr>
				<td>성별</td>
				<td>
					<select id="gender" name="gender" id="gender">
						<option value="1">남자</option>
						<option value="2">여자</option>
					</select>
			</tr>
			<tr>
				<td>전화번호</td>
				<td><input type="text" name="phone" id="phone"></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="등록">&nbsp;&nbsp;
					<input type="reset" value="취소">&nbsp;&nbsp;
					<input type="button" value="메인 페이지로 이동" onclick="employees/main.jsp">&nbsp;&nbsp;
				</td>
			</tr>
		</table>
		<table><tr><td colspan="2" >${message}</td></tr></table>
</form>
</body>
</html>