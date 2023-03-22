package com.attribute;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class S2 extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException{
		
		PrintWriter out=res.getWriter();
		
		int nn1=Integer.parseInt(req.getParameter("n1"));
		int nn2=Integer.parseInt(req.getParameter("n2"));
		
		int p=nn1*nn2;
		
		//Get Attribute from request object
		int sum=(int)req.getAttribute("sum");
		
		out.println("<h1>");
		out.println("Sum is: "+sum);
		out.println("Product is: "+p);
		out.println("</h1>");
	}
}
