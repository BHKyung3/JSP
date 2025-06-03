package unit05;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ParamServlet") //05_param.jsp에 기재된 action 값 기재(참조함)
public class ParamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8"); //필수, 반드시 기재
		
		String id = request.getParameter("id"); // id 값을 가지고 온다
		int age = Integer.parseInt(request.getParameter("age")); // age 값을 가지고 오고 Integer.parseInt 정수변환 한다
		
		PrintWriter out = response.getWriter();
		
		out.print("<html><body>");
		out.println("당신이 입력한 정보입니다.<br>");
		out.println("아이디 : ");
		out.println(id);
		out.println("<br>나이 : ");
		out.println(age);
		
		out.println("<br><a href='javascript:history.go(-1)'>다시</a>"); // 직전 페이지로 다시 이동하는 링크
		out.println("</body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
