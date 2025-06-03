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

@WebServlet("/join.do")
public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("employees/join.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		String name = request.getParameter("name");
		String lev = request.getParameter("lev");
		String gender = request.getParameter("gender");
		String phone = request.getParameter("phone");
		
		EmployeesVO eVO = new EmployeesVO();
		
		eVO.setId(id);
		eVO.setPass(pass);
		eVO.setName(name);
		eVO.setLev(lev);
		eVO.setGender(gender);
		eVO.setPhone(phone);
		
		// DB 연결
		EmployeesDAO eDao = EmployeesDAO.getInstance();
		
		// DB 저장할 메소드 호출
		int result = eDao.insertEmployees(eVO);
		
		HttpSession session = request.getSession();
		
		if(result==1) {
			session.setAttribute("id", eVO.getId());
			request.setAttribute("massage", "회원 등록에 성공했습니다.");
		} else {
			request.setAttribute("massage", "회원 등록에 실패했습니다.");
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("employees/login.jsp");
		dispatcher.forward(request, response);
	}

}
