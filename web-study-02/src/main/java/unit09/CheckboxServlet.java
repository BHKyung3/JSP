package unit09;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CheckboxServlet")
public class CheckboxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		out.print("<html><body>");
		
		String items[] = request.getParameterValues("item"); // 값이 복수이기 때문에 getParameterValues 기재 1건이면 getParameter
		if(items == null) {
			out.print("선택한 항목이 없습니다.");
		} else {
			out.print("당신이 선택한 항목입니다.<hr>");
			
			for(String item : items) {
				out.print(item + " ");
			}
		}
		
		out.println("<br><a href='javascript:history.go(-1)'>다시</a>"); // 직전 페이지로 다시 이동하는 링크
		out.println("</body></html>");
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
