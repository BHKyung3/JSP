<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action "mypage.do" method="post" name="frm" style="text-align: center;">
	<table border=1 solid width=100%>
		<tr>
			<td width=20%>${loginUser.name}님 반갑습니다.</td>
			<td width=20%>레벨 : ${loginUser.lev}</td>
			<td width=20%><a href='logout.do'>로그아웃</a></td>
			<td>
				<c:if test="${loginUser.lev=='A'}">
					<a href='custom.do'>사원 등록</a>
				</c:if>
				<c:if test="${loginUser.lev=='B'}">
					사원 등록<br>(관리자로 로그인 후 사용 가능)
				</c:if>
			</td>
			<td width=20%><a href='mypage.do?id=${loginUser.id}'>마이페이지</a></td>
		</tr>
	</table>
	<table style="margin: 0 auto;" border=1px solid black; width=50%>
			<tr>
				<td colspan="2"><h1>사원 정보</h1><br>회원 등록에 성공했습니다.</td>
			</tr>
			<tr>
				<td>아이디 </td>
				<td id="change"><input type="text" name="id" value="${eVo.id}" readonly="readonly"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td id="change"><input type="password" name="pass" value="${eVo.pass}"></td>
			</tr>
			<tr>
				<td>이름</td>
				<td id="change"><input type="text" name="name" value="${eVo.name}"></td>
			</tr>
			<tr>
				<td>권한</td>
				<td>
	 				<select id="lev" name="lev">
						<option value="A" <c:if test="${eVo.lev=='A'}"> selected</c:if>>운영자</option>
						<option value="B" <c:if test="${eVo.lev=='B'}"> selected</c:if>>일반 회원</option>
					</select>	
				</td>
			</tr>
			<tr>
				<td>성별</td>
				<td>
					<select id="gender" name="gender">
						<option value="1" <c:if test="${eVo.gender=='1'}"> selected</c:if>>남자</option>
						<option value="2" <c:if test="${eVo.gender=='2'}"> selected</c:if>>여자</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>전화번호</td>
				<td><input type="text" name="phone" value="${eVo.phone}"></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="수정" onclick="return "myPageCheck()">&nbsp;&nbsp;
					<input type="reset" value="취소">&nbsp;&nbsp;
				</td>
			</tr>
		</table>
</form>
</body>
</html>