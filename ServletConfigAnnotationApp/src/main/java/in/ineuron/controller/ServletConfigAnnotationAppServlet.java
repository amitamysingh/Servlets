package in.ineuron.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
		urlPatterns = { "/testAnnotationApp" }, 
		initParams = { 
				@WebInitParam(name = "url", value = "jdbc:mysql://localhost:3306/mydb"), 
				@WebInitParam(name = "userName", value = "root"), 
				@WebInitParam(name = "password", value = "root")
		})
public class ServletConfigAnnotationAppServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection connection=null;
	PreparedStatement pstmt=null;

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(ClassNotFoundException ce) {
			ce.printStackTrace();
		}
	}
	
	public void init() throws ServletException{
		String jdbcUrl=getInitParameter("url");
		String user=getInitParameter("userName");
		String password=getInitParameter("password");
		
		try {
			connection = DriverManager.getConnection(jdbcUrl,user,password);
			System.out.println("Connection established successfully...");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String userName = request.getParameter("userName");
		String userAge=request.getParameter("userAge");
		String userAddress=request.getParameter("userAddress");
		
		String sqlInsertQuery="insert into employeedetails(empname,empage,empaddress) values(?,?,?)";
		try {
			if(connection !=null)			
				pstmt=connection.prepareStatement(sqlInsertQuery);
				
				if(pstmt != null) {
					pstmt.setString(1, userName);
					pstmt.setInt(2, Integer.parseInt(userAge));
					pstmt.setString(3, userAddress);
					
					int count=pstmt.executeUpdate();
					PrintWriter out=null;
					System.out.println("No. of rows affected:: "+count);
					if(count == 1) {
						 out=response.getWriter();
						out.println("<h1 style= 'color:green; text-align:center;'>REGISTRATION SUCCESSFUL...</h1>");
						out.close();
					}else {
						out.println("<h1 style= 'color:red; text-align:center;'>REGISTRATION FAILED!"
								+ " TRY AGAIN WITH THE FOLLOWING LINK</h1>");
						out.println("<a href='./reg.html'/>|REGISTRATION|</a>");
						
						out.close();
					}
				}
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	public void destroy() {
		try {
			if(connection != null)
				connection.close();
			if(pstmt != null)
				pstmt.close();
			
		}catch(SQLException se) {
			se.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
