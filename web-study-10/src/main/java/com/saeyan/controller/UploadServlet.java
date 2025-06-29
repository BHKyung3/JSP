package com.saeyan.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/upload.do")
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); // 받을 때
		response.setContentType("text/html; charset=utf-8");// 보낼 때
		
		PrintWriter out = response.getWriter();
		
		// 업로드 경로
		String savePath = "upload";
		
		int uploadFileSizeLimit = 5*1025*1024;
		String encType = "utf-8";
		
		ServletContext context = getServletContext();
		String uploadFilePath = context.getRealPath(savePath);
		
		System.out.println("서버상 실제 폴더: " + uploadFilePath);
		
		// 저장
		try {
			MultipartRequest multi = new MultipartRequest(
				request,
				uploadFilePath, // 서버 디렉토리
				uploadFileSizeLimit, // 최대 업로드 파일 크기
				encType, // 인코딩 방법
				new DefaultFileRenamePolicy()
			);
			
			String fileName = multi.getFilesystemName("uploadFile");
			System.out.println("fileName: " + fileName);
			
			if(fileName == null) {
				System.out.println("파일이 업로드 되지 않았습니다.");
			} else {
				out.println("<br> 글쓴이 : " + multi.getParameter("name"));
				out.println("<br> 제목 : " + multi.getParameter("title"));
				out.println("<br> 파일명 : " + multi.getFilesystemName("uploadFile"));
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
