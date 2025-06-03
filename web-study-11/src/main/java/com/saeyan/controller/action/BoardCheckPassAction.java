package com.saeyan.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saeyan.dao.BoardDAO;
import com.saeyan.dto.BoardVO;

public class BoardCheckPassAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String num = request.getParameter("num");
		String pass = request.getParameter("pass");
		String url = null;
		
		// DB에서 가져와서 상세페이지 전달
		BoardDAO bDao = BoardDAO.getInstance();
		// DB에서 데이터 가져오기
		BoardVO bVo = bDao.selectOneBoardByNum(Integer.parseInt(num));
		// 게시판에 기재된 pass와 DB pass가 일치하면
		if(bVo.getPass().equals(pass)) {
			url = "/board/checkSuccess.jsp"; // 요기로 이동
		} else {
			url = "board/boardCheckPass.jsp"; // 아니면
			request.setAttribute("message", "비밀번호가 틀렸습니다."); // 여기
		}
		
		request.getRequestDispatcher(url).forward(request, response);
	}

}
