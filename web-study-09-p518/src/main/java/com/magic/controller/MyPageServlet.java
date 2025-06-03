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
public class MyPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		EmployeesDAO mDao = EmployeesDAO.getInstance();
		EmployeesVO eVo = mDao.getEmployees(id);
		
		request.setAttribute("eVo", eVo);  //mVo에 정보 저장
		
		request.getRequestDispatcher("employees/myPage.jsp").forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		String pass= request.getParameter("pass");  //변경은 안되지만 DAO클래스에서 updateMember에 userid를 쓰기 위해 넣어둠.
		String name = request.getParameter("name");
		String lev = request.getParameter("lev");
//		String enter = request.getParameter("enter");
		String gender = request.getParameter("gender");
		String phone = request.getParameter("phone");
		
		EmployeesVO eVo = new EmployeesVO();
		eVo.setId(id);
		eVo.setPass(pass);
		eVo.setName(name);
		eVo.setLev(lev);
//		eVo.setEnter(enter);
		eVo.setGender(gender);
		eVo.setPhone(phone);
		
		EmployeesDAO eDao = EmployeesDAO.getInstance();
		
		eDao.myPage(eVo);  //반환타입이 없으므로 굳이 int result = mDao.updateMember(mVo); 이런 식으로 쓸 필요 없음.
		
		response.sendRedirect("login.do");
	}

}
