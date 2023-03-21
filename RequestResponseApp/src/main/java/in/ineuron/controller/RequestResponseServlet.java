package in.ineuron.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/RequestResponseDemo")
public class RequestResponseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out  = response.getWriter();
		
		LocalDateTime date = LocalDateTime.now();
		int hour=date.getHour();
		System.out.println(hour);
		
		String msg="";
		if(hour < 12) {
			msg="Good Morning";
		}else if(hour <16) {
			msg+="Good After Noon";
		}else if(hour < 20) {
			msg+="Good Evening";
		}else {
			msg+="Good Night";
		}
		
		out.println("<h1 style= 'color:red; text-align:center;'>WELCOME TO SERVLET CODING...</h1>");
		out.println("<h1 style = 'color:blue; text-align:center;'>The current date and time is:: "+date+"</h1>");
		out.println("<h1 style= 'color:green; text-align: center;'>Greeting from the server:: "+msg+"</h1>");
		
		out.println("</br>Servlet Request address is:: "+request.hashCode());
		out.println("</br>Servlet Response address is:: "+response.hashCode());
		out.println("</br>Current Servlet object address is:: "+this.hashCode());
		out.println("</br>Current Request-Thread address is:: "+Thread.currentThread().hashCode());
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
