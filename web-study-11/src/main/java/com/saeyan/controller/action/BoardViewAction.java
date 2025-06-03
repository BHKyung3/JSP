package com.saeyan.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saeyan.dao.BoardDAO;
import com.saeyan.dto.BoardVO;

public class BoardViewAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int num = Integer.parseInt(request.getParameter("num"));

		// DB에서 가져와서 상세페이지 전달
		BoardDAO bDao = BoardDAO.getInstance();
		
		// 조회수 증가하는거
		bDao.updateReadCount(num);
		
		// DB에서 데이터 가져오기(num(primary key)에 해당하는 데이터(단건) 가져오기
		BoardVO bVo = bDao.selectOneBoardByNum(num); // selectOneBoardByNum 작성자 마음데로 만드는 메서드
		request.setAttribute("board", bVo);
		
		// boardView 화면으로 이동
		request.getRequestDispatcher("/board/boardView.jsp").forward(request, response);
		
	}


}
