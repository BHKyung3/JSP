package unti0401;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test_20250401")
public class test_20250401 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public test_20250401() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8"); // 출력 방식
		
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<head><title>서블릿 예제</title></head>");
		out.println("<boby>");
		out.println("<h2>서블릿 방식</h2>");
		out.println("<p>이 페이지는 서블릿에서 직접 HTML을 생성하여 출력합니다.</P>");
		out.println("</body>");
		out.println("</html>");
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
