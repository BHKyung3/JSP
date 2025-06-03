
/*
  	역할 : 게시글 DB에 저장하기, 하나의 서블릿(BoardServlet)에서 명령어(command)로 불려지는 역할
  	 ㄴ 저장용이기 때문에 구현하는 페이지가 없음(뒤에서 처리만 하고 다시 목록으로 보내버리는 역할)
 */


package com.saeyan.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saeyan.dao.BoardDAO;
import com.saeyan.dto.BoardVO;

public class BoardWriteAction implements Action { // Action(인터페이스) 구현

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// BoaadVO에 담아서 DB에 저장
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		String email = request.getParameter("email");
		String title = request.getParameter("title");
		String content = request.getParameter("content");

		// 박스에 담아서 보내기
		BoardVO bVo = new BoardVO();
		bVo.setName(name);
		bVo.setPass(pass);
		bVo.setEmail(email);
		bVo.setTitle(title);
		bVo.setContent(content);
		
		BoardDAO bDao = BoardDAO.getInstance();
		
		bDao.insertBoard(bVo); // insertBoard(); : BoardVO 객체를 인자로 받는 메서드
		
		// 책에는 new BoardListAction().execute(request, response);로 기재되어 있음
		response.sendRedirect("BoardServlet?command=board_list");
		
		
		
	}

}
