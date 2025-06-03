package com.magic.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.magic.dao.EmployeesDAO;
import com.magic.dto.EmployeesVO;



@WebServlet("/mypage.do")
public class MypageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		
		EmployeesDAO eDao = EmployeesDAO.getInstance();
		EmployeesVO eVO = eDao.getEmployees(id);
		// 수정페이지
		request.setAttribute("eVO", eVO);
		
		request.getRequestDispatcher("employees/mypage.jsp")
		.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		// 기본키인 userid만 못바꾸고 나머지는 다 변경 가능함
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		String name = request.getParameter("name");
		String lev = request.getParameter("lev");
//		String enter = request.getParameter("enter");
		String gender = request.getParameter("gender");
		String phone = request.getParameter("phone");
		
		EmployeesVO eVO = new EmployeesVO();
		eVO.setId(id);
		eVO.setPass(pass);
		eVO.setName(name);
		eVO.setLev(lev);
//		eVO.setEnter(enter);
		eVO.setGender(gender);
		eVO.setPhone(phone);
		
		EmployeesDAO eDao = EmployeesDAO.getInstance();
		eDao.updateEmployees(eVO);
		
		response.sendRedirect("login.do");
	}

}
