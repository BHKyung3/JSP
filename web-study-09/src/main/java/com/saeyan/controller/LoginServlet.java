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

@WebServlet("/login.do") // 이 서블릿은 /login.do 경로로 요청이 들어올 때 실행, 브라우저 주소창에 /login.do 요청을 보내면 이 서블릿이 동작
public class LoginServlet extends HttpServlet { // 클래스 선언 HttpServlet을 상속받은 서블릿 클래스 => 클라이언트 요청을 받아 처리할 수 있음 (doGet, doPost 메서드로)

	private static final long serialVersionUID = 1L;
       
	// doGet() 메서드 - 로그인 페이지 보여주기 => 사용자가 /login.do를 GET 방식으로 요청하면, member/login.jsp 파일로 화면 전환 (포워딩)됨
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "member/login.jsp";
		
		HttpSession session = request.getSession();
		
		if(session.getAttribute("loginUser") != null) { // 이미 로그인되어 있는 사용자는

			MemberVO mVO = (MemberVO)session.getAttribute("loginUser"); // 이름 변경 시 변경된 정보를 노출하는 방법j
			
			MemberDAO mDao = MemberDAO.getInstance();
			mVO = mDao.getMember(mVO.getUserid());
			
			session.setAttribute("loginUser", mVO);
			url = "main.jsp"; // 메인 페이지로 이동한다
		}
		
		RequestDispatcher dis = request.getRequestDispatcher(url);
		dis.forward(request, response); // forward()는 내부 페이지 이동이라 주소는 그대로 /login.do로 보이고, 화면은 login.jsp가 나타나.
	}

	// 로그인 폼에서 아이디/비밀번호 입력하고 로그인 버튼을 누르면 POST 방식으로 요청되며, 이 메서드가 실행됨.
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 아이디, 비번 파라미터 받기
		String userid = request.getParameter("userid");
		String pwd = request.getParameter("pwd"); // 로그인 화면에서 전송된 아이디(userid)와 비밀번호(pwd) 값을 받아옴
		
		System.out.println(userid);
		System.out.println(pwd);
		String url = "member/login.jsp";
		
		// DB연결해서 userid, pwd 해당 자가 있는지 확인!(로그인 검증)
		MemberDAO mDao = MemberDAO.getInstance(); // MemberDAO라는 DAO 클래스에서 로그인 정보 확인
		int result = mDao.userCheck(userid, pwd); // userCheck() 메서드가 로그인 검증 역할
		
		if(result == 1) { // result 1이면 정상 회원가입
			MemberVO mVO = mDao.getMember(userid); // mVO 객체를 생성해서 DB에 있는 정보를 가져와 참조하게 해줘야 한다
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", mVO);
			request.setAttribute("message", "회원 가입에 성공 했습니다.");
			url = "main.jsp";
			
		}else if(result == 0) {
			request.setAttribute("message", "비밀번호가 맞지 않습니다."); // result 0이면 비밀번호 메세지 노출
		} else if(result == -1) {
			request.setAttribute("message", "존재하지 않는 회원입니다.");// result -1이면 존자하지 메세지 노출
		}
		
		request.getRequestDispatcher(url).forward(request, response); // 최종 화면 이동
	}

}

/* 정상으로 뜨는지 확인하는 용도로 사용
		switch(result) {
		case 1 :
			System.out.println("로그인 여부 : 성공");
			break;
		case 0 :
			System.out.println("로그인 여부 : 비밀번호 오류");
			break;
		case -1 :
			System.out.println("로그인 여부 : 아이디 오류");
			break;
		}
		
		System.out.println("로그인 여부: " + result);
 */