package com.saeyan.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.saeyan.dao.MemberDAO;
import com.saeyan.dto.MemberVO;

@WebServlet("/join.do") //사용자가 브라우저에서 /join.do 주소로 요청을 보내면 이 서블릿이 실행됨.
public class JoinServlet extends HttpServlet { // HttpServlet을 상속받았으니 doGet()과 doPost()로 클라이언트 요청 처리 가능.
	private static final long serialVersionUID = 1L;
       
	// 회원가입 페이지 연결, 브라우저가 /join.do로 GET 요청을 보냈을 때 실행됨. 사용자가 회원가입 화면을 보고 싶을 때 동작하는 메서드
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("member/join.jsp").forward(request, response);
	}

	// 사용자가 /join.do로 POST 요청을 보냈을 때 실행됨.
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String name = request.getParameter("name");
		String userid = request.getParameter("userid");
		String pwd = request.getParameter("pwd");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String admin = request.getParameter("admin");
		
		// box에 넣는다
		MemberVO mVO = new MemberVO();
		mVO.setName(name);
		mVO.setUserid(userid);
		mVO.setPwd(pwd);
		mVO.setEmail(email);
		mVO.setPhone(phone);
		mVO.setAdmin(Integer.parseInt(admin));
		
		// DB 연결
		MemberDAO mDao = MemberDAO.getInstance();
		
		// DB 저장할 메소드 호출
		int result = mDao.insertMember(mVO);
		
		HttpSession session = request.getSession();
		
		if(result==1) {
			session.setAttribute("userid", mVO.getUserid());
			request.setAttribute("massage", "회원 가입에 성공했습니다.");
		} else {
			request.setAttribute("massage", "회원 가입에 실패했습니다.");
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("member/login.jsp");
		dispatcher.forward(request, response);
	}

}
