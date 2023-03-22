package com.CookieAndSession;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class S2 extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException{
		
		PrintWriter out=res.getWriter();
		
		
		//Getting all the cookies
		Cookie[] cookies=req.getCookies();
		boolean f=false;
		String name="";
		
		if(cookies==null) {
			out.println("<h2> You are new user, go to home page and submit your name</h2>");
			return;
		}else {
			for(Cookie c:cookies) {
				String tname=c.getName();
				if(tname.equals("userName")) {
					f=true;
					name=c.getValue();
				}
			}
		}
		if(f) {
			out.println("<h1> Hello, " + name +" welcome back to my website...</h1>");
			out.println("<h1> Thankyou </h1>");
		}else {
			out.println("<h2> You are new user, go to home page and submit your name</h2>");
		}

	}
}
