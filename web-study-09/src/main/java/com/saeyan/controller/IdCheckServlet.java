package com.saeyan.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saeyan.dao.MemberDAO;

// 주로 회원가입 폼에서 "아이디 중복 확인" 버튼을 눌렀을 때 AJAX나 form 방식으로 호출되는 경로
@WebServlet("/idCheck.do") // /idCheck.do 주소로 요청이 오면 이 서블릿이 실행
public class IdCheckServlet extends HttpServlet { // HttpServlet을 상속받은 서블릿 클래스.
	private static final long serialVersionUID = 1L;
    
	// 아이디 중복 체크 처리
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userid = request.getParameter("userid"); // 아이디 가져오기
		
		MemberDAO mDao = MemberDAO.getInstance(); // DB에서 해당 아이디 있는지 확인
		int result = mDao.confirmID(userid); // confirmID() 메서드는 DB에서 해당 아이디가 있는지 확인
		
		// JSP에 결과 전달 (Request Scope에 저장)
		request.setAttribute("userid", userid); // set으로 던지거임 get로 받아야햠
		request.setAttribute("result", result);
		
		request.getRequestDispatcher("member/idCheck.jsp").forward(request, response); // 결과를 JSP로 포워딩
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
