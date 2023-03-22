package in.ineuron.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class WODATestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Implementation class of the tomcat server:: ");
		ServletConfig config=getServletConfig();
		ServletContext context=getServletContext();
		System.out.println("Implementation class of the config is:: "+config.getClass().getName());
		System.out.println("Impelmentation class of the context is:: "+context.getClass().getName());
		System.out.println("Implementation class of the request is:: "+request.getClass().getName());
		System.out.println("Implementation class of the reponse is:: "+response.getClass().getName());
		
	}

}
