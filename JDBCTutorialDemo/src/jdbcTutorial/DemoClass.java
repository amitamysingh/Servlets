package jdbcTutorial;
import java.sql.*;
public class DemoClass {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		String url="";
		String username="";
		String password="";
		Connection con =DriverManager.getConnection(url, username, password) ;
	}

}
