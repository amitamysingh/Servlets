package in.ineuron.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class DBController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	//Load the DB
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver class loaded");
		}catch(ClassNotFoundException ce) {
			ce.printStackTrace();
		}
	}
	Connection connection=null;
	
	public void init() throws ServletException{
		String url=getInitParameter("url");
		String userName=getInitParameter("userName");
		String password=getInitParameter("password");
		System.out.println(url);
		System.out.println(userName);
		System.out.println(password);
		
		try {
			connection=DriverManager.getConnection(url, userName, password);
			if(connection != null) {
				System.out.println("Connection established....");
			}
		}catch(SQLException se) {
			se.printStackTrace();
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.println("<h1>Request type is:: "+request.getMethod() +"</h1>");
				
		
		Statement statement=null;
		ResultSet resultSet=null;
		
		try {
			statement=connection.createStatement();
			resultSet=statement.executeQuery("select sid,sname,sage,saddress,sgender from student");
			while(resultSet.next()) {
				//process the data
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
