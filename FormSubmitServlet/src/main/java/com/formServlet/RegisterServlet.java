package com.formServlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class RegisterServlet extends HttpServlet{
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<h1>Welcome to register Servlet</h1>"); 
		
		//Take all the details from user
		String name=request.getParameter("user_name");
		String password=request.getParameter("password");
		String email=request.getParameter("mail_id");
		String gender=request.getParameter("user_gender");
		String course=request.getParameter("user_course");
		
		String cond=request.getParameter("condition_agreed");
		
		if(cond!=null) {
		if(cond.equals("checked")) {
			out.println("<h2> Name: "+name +"<h2>");
			out.println("<h2> Password: "+password +"</h2>");
			out.println("<h2> Email: "+email +"</h2>");
			out.println("<h2> Gender: "+gender +"</h2>");
			out.println("<h2> Course: "+course +"</h2>");
			
			//JDBC
			
			//saved to db
			
			//Success Message Dispatcher
			RequestDispatcher rd=request.getRequestDispatcher("success");
			//Invoking forward() method
			rd.forward(request, response);
		}else {
			out.println("<h2> You have not agreed to terms and conditions </h2>");
		}
		}else {
			out.println("<h2> You have not agreed to terms and conditions </h2>");
			
			//I want to include output of index.html
			
			//Get the object of Request Dispatcher
			
			RequestDispatcher rd= request.getRequestDispatcher("index.html");
			
			//invoking include() method
			rd.include(request, response);
		}
	}

}
