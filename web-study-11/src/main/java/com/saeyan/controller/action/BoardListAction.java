
/*
  	역할 : 게시글 목록 보여주는 기능(게시글 리스트 불러오기), 하나의 서블릿(BoardServlet)에서 명령어(command)로 불려지는 역할
 */

package com.saeyan.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saeyan.dao.BoardDAO;
import com.saeyan.dto.BoardVO;

public class BoardListAction implements Action { // Action(인터페이스) 구현

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String url = "/board/boardList.jsp";
		
		BoardDAO bDao = BoardDAO.getInstance(); // DB 접속하겠다
		List<BoardVO> boardList = bDao.selectAllBoards(); //DB 정보 참조하고 있음
		
		request.setAttribute("boardList", boardList); // 정보를 여기 담아서 
		
		// forword => boardList.jsp 이동
		request.getRequestDispatcher(url).forward(request, response); // 결과를 URL(boardList.jsp)에 전달하겠다
		
	}

}
