<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<%
		int age = Integer.parseInt(request.getParameter("age")); // 문자로 인식하기에 숫자로 변환 시켜줘야함
		if (age <= 19) {
	%>
		<script type="text/javascript">
			alert("19세 미만이므로 입장하실 수 없습니다.");
			history.go(-1);
		</script>
	<%
		} else {
			request.setAttribute("name", "성윤정");
			RequestDispatcher dis = request.getRequestDispatcher("05_forwardResult.jsp");
			
			dis.forward(request, response);
		}
	%>