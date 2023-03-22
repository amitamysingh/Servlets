package com.practice;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class MyServlet extends HttpServlet{
	   public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	        
	        System.out.println("this is get method........");
	        response.setContentType("text/html");
	        PrintWriter out=response.getWriter();
	        
	        out.println("<h1>this is get method of my servlet </h1>");
	    }
}
