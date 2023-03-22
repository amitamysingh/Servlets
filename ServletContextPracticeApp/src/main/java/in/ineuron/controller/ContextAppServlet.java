package in.ineuron.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ContextAppServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	static {
		System.out.println("ContextAppServlet.class file is loading...");
	}
	
	public ContextAppServlet() {
		System.out.println("ContextAppServlet is instantiated...");
	}
	
	public void init() throws ServletException{
		System.out.println("ContextAppServlet Object is initialised with config Object data");
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		out.println("<html><head><title>OUTPUT</title></head>");
		out.println("<body>");
		out.println("<center>");
		out.println("<h1 style='color:green; text-align:center;'>CONTEXT PARAMETER INFORMATION</h1>");
		out.println("<table border='1'>");
		out.println("<tr><th>Parameter Name</th><th>Parameter Value</th></tr>");
		ServletContext context=getServletContext();
		Enumeration<String> parameterNames=context.getInitParameterNames();
		while(parameterNames.hasMoreElements()) {
			
			String parameterName= (String) parameterNames.nextElement();
			String parameterValue=context.getInitParameter(parameterName);
			
			out.println("<tr>");
			out.println("<td>"+parameterName+"</td>");
			out.println("<td>"+parameterValue+"</td>");
			out.println("<tr>");
		}
		out.println("</table>");
		out.println("</center>");
		out.println("</body>");
		out.println("</html>");
		
	}

}
