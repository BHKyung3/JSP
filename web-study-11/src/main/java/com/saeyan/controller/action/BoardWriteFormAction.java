
/*
  	역할 : 글쓰기 폼 화면으로 이동(글쓰기 화면 보여주기), 하나의 서블릿(BoardServlet)에서 명령어(command)로 불려지는 역할
 */

package com.saeyan.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoardWriteFormAction implements Action { // Action(인터페이스) 구현

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("/board/boardWrite.jsp").forward(request, response); // 폼만 만드면 됨
		
	}

}
