package unit01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BasketeServlet")
public class BasketeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		
		String id = request.getParameter("id");
		
		PrintWriter out = response.getWriter();
		
		out.print("<html><body>");
		out.println("<h2>선택한 상품 : p0" + id + "</h2>");
		out.println("<img src='images/" + id + ".jpg' width='300px' alt='상품 이미지'>");
		
		out.println("<hr><br><br><a href='javascript:history.go(-1)'>상품 선택 화면</a>");
		out.println("</body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
