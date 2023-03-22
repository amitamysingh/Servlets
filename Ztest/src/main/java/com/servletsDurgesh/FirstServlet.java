package com.servletsDurgesh;

import java.io.IOException;

import javax.servlet.*;

public class FirstServlet implements Servlet{
	//LifeCycle Methods
	
	ServletConfig config;
	
	public void init(ServletConfig config) {
		this.config=config;
		System.out.println("creating object:...");
	}
	
	public void service(ServletRequest req, ServletResponse resp) throws ServletException,IOException{
		System.out.println("Servicing...");
	}
	
	public void destroy() {
		System.out.println("going to destroy servlet object");
	}
	
	//Non-LifeCycle Methods
	
	public ServletConfig getServletConfig() {
		return this.config;
	}
	
	public String getServletInfo() {
		return "Servlet created by Amit Kumar Singh";
	}
}
