package com.magic.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.magic.dao.EmployeesDAO;
import com.magic.dto.EmployeesVO;



@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//doGet() → 로그인 화면으로 이동
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	String url = "employees/login.jsp";
	
	HttpSession session = request.getSession();
	
	if(session.getAttribute("loginUser") != null) {
		
		EmployeesVO eVo = (EmployeesVO)session.getAttribute("loginUser");
		
		EmployeesDAO mDao = EmployeesDAO.getInstance();
		eVo = mDao.getEmployees(eVo.getId());
		session.setAttribute("loginUser", eVo);
		url = "main.jsp";
	}
	
	RequestDispatcher dispatcher = request.getRequestDispatcher(url);
	dispatcher.forward(request, response);
	}
	
	//doPost() → 로그인 검증 및 처리	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//로그인 폼에서 입력한 userid, pwd를 가져옴
				//getParameter - 클라이언트의 HTML 페이지에서 필요한 정보를 얻는 데 사용됩니다.  		//getAttribute - 이전에 다른 JSP 또는 Servlet 페이지에 설정된 매개 변수를 가져 오는 데 사용됩니다.
				String id = request.getParameter("id");
				//("userid")가 login.jsp의 name="userid".  login.jsp의 name="userid"의 값이 value(사용자가 입력한 값)이고
				//이 사용자가 입력한 값을 html에서 가져오는 게 getParameter.
				//그래서 이 사용자가 입력한 값이 String userid 값이 됨.
				String pass = request.getParameter("pass");
				String lev = request.getParameter("lev");
				
				String url = "employees/login.jsp";
				
				//DB연결해서 userid, pwd 해당 자가 있는지 확인!
				EmployeesDAO eDao = EmployeesDAO.getInstance();
				//userCheck() 메서드를 호출해서 로그인 가능 여부 확인
				int result =  eDao.userCheck(id, pass, lev);
				/*
				switch(result) {
					case  1:
						System.out.println("로그인 여부 :  성공" );	
					break;
					case 0:
						System.out.println("로그인 여부 :  비번 틀림 ");
						break;
					case -1 : 
						System.out.println("로그인 여부 :  아이디 틀림 ");
						break;		
				}
				System.out.println("로그인 여부 :  " + result );
				*/
				
				if(result == 1) {
					//로그인한 회원의 정보를 가져옴 (getMember()) => 아이디로 회원 전체 정보를 가져오는 메서드
					EmployeesVO eVo = eDao.getEmployees(id);
					//세션(서버 메모리)에 loginUser라는 이름으로 저장함
					HttpSession session = request.getSession();
					//메시지를 JSP에 전달
					session.setAttribute("loginUser", eVo);			
					request.setAttribute("message", "회원 가입에 성공했습니다.");
					//메시지 저장 후 main.jsp로 이동
					url = "main.jsp";			
				}else if(result == 0) {
					//오류 메시지를 request에 저장. 다시 login.jsp로 돌아감 (url이 그대로 "member/login.jsp"로 유지)
					request.setAttribute("message", "비밀번호가 맞지 않습니다.");			
				}else if(result == -1) {
					////오류 메시지를 request에 저장. 다시 login.jsp로 돌아감 (url이 그대로 "member/login.jsp"로 유지)
					request.setAttribute("message", "존재하지 않는 회원입니다.");
				}else if(result == -2) {
					request.setAttribute("message", "권한을 확인하세요.");
				}
				
				//url 변수에 따라 성공이면 main.jsp, 실패면 login.jsp로 이동
				request.getRequestDispatcher(url).forward(request, response); 
			}

		}