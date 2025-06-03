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

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "employees/login.jsp";
		
		HttpSession session = request.getSession();
		
		if(session.getAttribute("loginUser") != null) {
			EmployeesVO eVO = (EmployeesVO)session.getAttribute("loginUser");
			EmployeesDAO eDao = EmployeesDAO.getInstance();
			eVO = eDao.getEmployees(eVO.getId());
			session.setAttribute("loginUser", eVO);
			url = "main.jsp";
		}
		
		RequestDispatcher dis = request.getRequestDispatcher(url);
		dis.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");

		String url = "employees/login.jsp";
		EmployeesDAO eDao = EmployeesDAO.getInstance();
		
		int result =  eDao.userCheck(id, pass);

			
			if(result == 1) {
				EmployeesVO eVO = eDao.getEmployees(id);
				HttpSession session = request.getSession();
				session.setAttribute("loginUser", eVO);
				request.setAttribute("message", "로그인에 성공 했습니다.");
				url = "main.jsp";
			} else if(result == 0) {
				request.setAttribute("message", "비밀번호가 맞지 않습니다.");
			} else if(result == -1) {
				request.setAttribute("message", "아이디가 맞지 않습니다.");
			}

		request.getRequestDispatcher(url).forward(request, response);
	}
}