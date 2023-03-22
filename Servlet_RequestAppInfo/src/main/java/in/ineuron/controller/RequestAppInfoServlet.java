package in.ineuron.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/testRequestApp/iNeuron/*")
public class RequestAppInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		out.println("<h1>Rerquest URI:: "+request.getRequestURI()+"</h1");
		out.println("<h1>Context path:: "+request.getContextPath()+"</h1>");
		out.println("<h1>Servlet path:: "+request.getServletPath()+"</h1>");
		out.println("<h1>Query String:: "+request.getQueryString()+"</h1>");
		out.println("<h1>Path Info:: "+request.getPathInfo()+"</h1>");
		out.println("<h1>IP Address:: "+request.getRemoteAddr()+"</h1>");
		out.close();
	}

}
