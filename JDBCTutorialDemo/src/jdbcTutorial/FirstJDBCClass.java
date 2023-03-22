package jdbcTutorial;
import java.sql.*;

public class FirstJDBCClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
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
        }catch(Exception e){
            e.printStackTrace();
        }
	}

}
