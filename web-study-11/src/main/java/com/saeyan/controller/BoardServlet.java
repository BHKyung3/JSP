
/*
  	BoardServlet = DispatcherServlet(Spring에서 사용하는 용어)와 같음
  	 ㄴ 1개만 존재하고 Action한테 일을 시키는 역할(단 그 전에 어떤 Action을 할 지 선택하는 역할은 ActionFactory 해줌)
 */

package com.saeyan.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saeyan.controller.action.Action;
import com.saeyan.controller.action.ActionFactory;

// Spring 에서는 DispatcherServlet(또는 Front Controller)
@WebServlet("/BoardServlet") // 이게 기재되어 있으면 web.xml에 따로 서블릿 매핑 불필요
public class BoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// BoardServlet?command=board_write
		String command = request.getParameter("command");
		System.out.println("BoardServlet에서 요청 받음을 확인 : " + command); // 이 코드가
		
		ActionFactory af = ActionFactory.getInstance(); // 받아서 
		Action action = af.getAction(command); // 얘한테 전달
		
		if(action != null) {
			action.execute(request, response); // action이 null 값이 아니면 request 또는 response 실행, execute 동작
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
