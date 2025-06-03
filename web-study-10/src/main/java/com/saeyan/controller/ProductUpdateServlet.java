package com.saeyan.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.saeyan.dao.ProductDAO;
import com.saeyan.dto.ProductVO;

@WebServlet("/productUpdate.do")
public class ProductUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { // 수정할 때
		
		String code = request.getParameter("code"); // code 기준으로 db에 가서 내용을 보여줘
		// code는 숫자로 정수형으로 변환을 해야하는데 여기서 해도 되고 ProductDAO에서 DB 연결할 때 변경해도 됨
		
		ProductVO pVo = ProductDAO.getInstance().selectProductByCode(code); // code 기준으로 db에 가서 데이터를 가지고 와서 pVo에 데이터를 집어 넣고
		// DB 연결
		
		request.setAttribute("product", pVo);

		request.getRequestDispatcher("product/productUpdate.jsp").forward(request, response);
	}
	// 수정 데이터 DB 전달
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { // 수정하면 기재될 항목
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		ServletContext context = getServletContext();
		String path = context.getRealPath("upload");
		
		String encType = "utf-8";
		
		int sizeLimit = 20*1024*1024; // 20MB
		
		MultipartRequest multi = new MultipartRequest (
			request, path, sizeLimit, encType, new DefaultFileRenamePolicy());
			
		//	System.out.println(path); => 수정 시 이미지가 잘 반영되는지 확인하기 위함
		
			int code = Integer.parseInt(multi.getParameter("code"));
			String name = multi.getParameter("name");
			int price = Integer.parseInt(multi.getParameter("price"));
			String pictureurl = multi.getFilesystemName("pictureurl");
			String description = multi.getParameter("description");
			
			// 수정 시 이미지를 첨부하지 않으면 기본 이미지 사용(noimage.gif)
			if(pictureurl == null) {
				pictureurl = multi.getParameter("nonmakeImg");
			}
			
			ProductVO pVo = new ProductVO();
			
			pVo.setCode(code);
			pVo.setName(name);
			pVo.setPrice(price);
			pVo.setPictureurl(pictureurl);
			pVo.setDescription(description);
			
			ProductDAO.getInstance().updateProduct(pVo); // DB 업데이트
			
			response.sendRedirect("productList.do"); // 리스트 목록으로 이동
		
	}

}
