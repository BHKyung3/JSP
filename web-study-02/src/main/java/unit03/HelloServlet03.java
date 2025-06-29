package unit03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/HelloServlet03")
public class HelloServlet03 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public HelloServlet03() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
//		입력된 타입에 따라 출력값이 달라 타입을 잘 작성해야함 : plain -> 평문 문자로 인식, html -> 문서로 인식
//		입력한 한글을 잘 나타내기 위해는 위에 기재된 "text/html;charset=utf-8"로 작성해야 정상적으로 나타남
		
		PrintWriter out = response.getWriter();
		
		out.println("<html><body><h1>");
		out.println("Hello Servlet");
		out.println("헬로우 서블릿"); // 한글 깨짐(번역이 잘못되어서)
		out.println("</h1></body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
