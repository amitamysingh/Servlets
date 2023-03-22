package jdbcTutorial;

import java.sql.DriverManager;
import java.sql.*;
import java.io.*;

public class ImageSave {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			
			//Database Details
			String url="jdbc:mysql://localhost:3306/mydb";
			String username="root";
			String password="root";
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,username,password);
			
			//Query to insert picture
			String q="insert into imaages(pic) values(?)";
			
			PreparedStatement pstmt=con.prepareStatement(q);
			//pstmt.setString(1,"myName");
			
			//Take images input
			FileInputStream fis=new FileInputStream("C:\\Users\\shubh\\Downloads\\jdbcImage.jpg");
			pstmt.setBinaryStream(1,fis,fis.available());
			
			pstmt.executeUpdate();
			System.out.println("Done");
			pstmt.close();
			con.close();
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
