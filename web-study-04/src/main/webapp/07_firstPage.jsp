<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% 
	pageContext.setAttribute("name", "page man");
	request.setAttribute("name", "request man");
	session.setAttribute("name", "session man");
	application.setAttribute("name", "application man");
	
	System.out.println("firstPage.jsp: ");
	System.out.println("pageContext: " + pageContext.getAttribute("name"));
	System.out.println("request: " + request.getAttribute("name"));
	System.out.println("session: " + session.getAttribute("name"));
	System.out.println("application: " + application.getAttribute("name"));
	
	request.getRequestDispatcher("07_secondPage.jsp").forward(request, response);

%>