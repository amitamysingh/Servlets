/**
 * 
 */
package jdbcTutorial;
import java.sql.*;
import java.io.*;

/**
 * @author shubh
 *
 */
public class InsertPreparedStatement {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url="jdbc:mysql://localhost:3306/mydb";
			String username = "root";
			String password = "root";
			
			Connection con=DriverManager.getConnection(url,username,password);
			
			//Insert Query
			String q = "insert into table1(tname,tcity) values(?,?)";
			String query = "select tName from table1 where tId='3'";
			//get the prepared statement
			PreparedStatement pstmt = con.prepareStatement(q);
			
			//Taking input from User
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter name :");
			String nameInput=br.readLine();
			
			System.out.println("Enter City:");
			String cityInput=br.readLine();
			//set the values to query
			pstmt.setString(1, nameInput);
			pstmt.setString(2, cityInput);
			
			pstmt.executeUpdate();
			
			System.out.println("Inserted");
			
			Statement st = con.createStatement();
			ResultSet res = st.executeQuery(query);
			res.next();
			
			String name=res.getString("tName");
			
			System.out.println(name);
			st.close();
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}

	} 
}
