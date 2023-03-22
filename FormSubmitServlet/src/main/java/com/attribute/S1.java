/**
 * 
 */
package com.attribute;

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
		
		String n1=req.getParameter("n1");
		String n2=req.getParameter("n2");
		
		int nn1=Integer.parseInt(n1);
		int nn2=Integer.parseInt(n2);
		
		//add 
		int s=nn1+nn2;
		
		//Set Attribute
		req.setAttribute("sum", s);
		
		//Forward request using request dispatcher
		RequestDispatcher rd=req.getRequestDispatcher("s2");
		
		rd.forward(req, res);
	}
}
