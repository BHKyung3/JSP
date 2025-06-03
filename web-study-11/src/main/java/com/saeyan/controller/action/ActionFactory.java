
/*
 	역할 : 요청 분기 관리자(어떤 요청에 어떤 Action을 실행할지 결정), 어떤 애한테 일을 시킬지 정해주는 관리자
 	 ㄴ 1개만 필요(if를 사용하여 각 항목에 맞게 객체를 생성함
 */

package com.saeyan.controller.action;

public class ActionFactory {
	
	private static ActionFactory instance = new ActionFactory(); // 객체 생성, 싱글톤 패턴(1개로 같이 사용하겠다( , 외부 사용 불가
	
	private ActionFactory() { // 싱글톤 패턴
	}
	
	public static ActionFactory getInstance() {
		return instance;
	}
	
	public Action getAction(String command) {
		Action action = null;
		
		System.out.println("ActionFactory : " + command);
		
		if(command.equals("board_list")) {
			action = new BoardListAction(); // 반드시 액션 인터페이스 구현 필요
		} else if(command.equals("board_write_form")) { // 만약 board_write_form라면
			action = new BoardWriteFormAction(); // 이걸로 객체 생성
		} else if(command.equals("board_write")) {
			action = new BoardWriteAction();
		} else if(command.equals("board_view")) {
			action = new BoardViewAction();
		} else if(command.equals("board_check_pass_form")) {
			action = new BoardCheckPassFromAction();
		} else if(command.equals("board_check_pass")) {
			action = new BoardCheckPassAction();
		}else if(command.equals("board_delete")) {
			action = new BoardDeleteAction();
		} else if(command.equals("board_update_form")) {
			action = new BoardUpdateFormAction();
		} else if(command.equals("board_update")) {
			action = new BoardUpdateAction();
		}
		
		return action;
	}

}
