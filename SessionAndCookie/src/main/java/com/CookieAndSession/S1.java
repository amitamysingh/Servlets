/**
 * 
 */
package com.CookieAndSession;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.http.*;

/**
 * @author shubh
 *
 */
public class S1 extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException{
		
		PrintWriter out=res.getWriter();
		
		String name=req.getParameter("name");
		out.println("<h1> Hello, " + name + " welcome to my website...</h1>");
		out.println("<h1><a href='servlet2'>Go to servlet2></h1>");
		
		//Create a Cookie
		Cookie cookie=new Cookie("userName", name);
		
		//Add Cookie to the response
		res.addCookie(cookie);

	}
}
