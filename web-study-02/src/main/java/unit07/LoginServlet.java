package unit07;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		PrintWriter out = response.getWriter();
		
		out.print("<html><body>");
		out.println("당신이 입력한 정보입니다.<br>");
		out.println("아이디 : ");
		out.println(id);
		out.println("<br>비밀번호 : ");
		out.println(pwd);
		
		out.println("<br><a href='javascript:history.go(-1)'>다시</a>"); // 직전 페이지로 다시 이동하는 링크
		out.println("</body></html>");
		out.close();
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
