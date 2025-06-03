
/*
  역할 : 모든 기능(게시판 글 목록, 글 작성, 글 삭제 등)이 공통된 방식으로 실행될 수 있게 만드는 약속
   ㄴ 다형성을 이용하려고 인터페이스로 만듬
  모든 액션 클래스들이 따라야할 규칙을 정의 : 때문에 1개만 만들면 됨
 */

package com.saeyan.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action {
	
	public void execute(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException;

}
