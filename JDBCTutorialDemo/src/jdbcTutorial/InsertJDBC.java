package jdbcTutorial;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class InsertJDBC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			 // Load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Create a connection
            String url="jdbc:mysql://localhost:3306/mydb";
            String username="root";
            String password="root";

            Connection con= DriverManager.getConnection(url,username,password);
            
            if(con.isClosed()){
                System.out.println("Connection is still closed");
            }else{
                System.out.println("Connection created");
            }
            
            //Query to Create a Table => tId tName tCity    
            String q="create table mydb.table1 (tId int(20) primary key auto_increment, tName varchar(200) not null, tCity varchar(400))";
            
            //Create a statement
            Statement stmt=con.createStatement();
            
            stmt.executeUpdate(q);
            
            System.out.println("Table Created in DataBase");
            
            //Close the connection
            con.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
