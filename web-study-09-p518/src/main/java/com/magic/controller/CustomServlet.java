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


@WebServlet("/custom.do")
public class CustomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("employees/custom.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");//이거 안 하면 db에 한글이 깨진 채로 저장됨
		
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		String name = request.getParameter("name");
		String lev = request.getParameter("lev");
		String gender = request.getParameter("gender");
		String phone = request.getParameter("phone");
	
		EmployeesVO eVo = new EmployeesVO();

		eVo.setId(id);
		eVo.setPass(pass);
		eVo.setName(name);
		eVo.setLev(lev);
		eVo.setGender(gender);
		eVo.setPhone(phone);

		
		//1.DB연결
		EmployeesDAO eDao = EmployeesDAO.getInstance();
		
		//2.DB에 저장할 메소드 호출
		int result = eDao.insertEmployees(eVo);
		
//		HttpSession session=request.getSession();
		
		if(result==1) {
//			session.setAttribute("id", eVo.getId());
			request.setAttribute("message", "회원 등록에 성공했습니다.");
		}else {
			request.setAttribute("message", "회원 등록에 실패했습니다.");
		}
		
		RequestDispatcher dis = request.getRequestDispatcher("employees/custom.jsp");
		dis.forward(request, response);
		
	}
}
