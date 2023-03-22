package in.ineuron.persistence;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import in.ineuron.dto.Employee;
import in.ineuron.jdbcUtility.JDBCUtility;

public class EmployeeDaoImpl implements IEmployeeDao {
	
	Connection connection=null;
	PreparedStatement pstmt=null;
	ResultSet resultSet=null;
	
	@Override
	public String addEmployee(String empName, int empAge, String empAddress) {
		// TODO Auto-generated method stub
			
			try {
				connection=JDBCUtility.getJdbcConnection();
				String sqlInsertQuery="insert into employeedetails (`empname`, `empage`, `empaddress`) values(?,?,?)";
				if(connection != null)
					pstmt=connection.prepareStatement(sqlInsertQuery);
				
				if(pstmt != null) {
					pstmt.setString(1, empName);
					pstmt.setInt(2, empAge);
					pstmt.setString(3, empAddress);
					
					int rowAffected=pstmt.executeUpdate();
					
					if(rowAffected == 1)
						return "success";
					
						
				}
				
			} catch (SQLException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
		
			return "failure";
	}

	@Override
	public Employee searchEmployee(Integer empId) {
		// TODO Auto-generated method stub
		Employee employee=null;
		
		try {
			connection=JDBCUtility.getJdbcConnection();
			String sqlSelectQuery="select empId,empName,empage,empaddress from employeedetails where empid=?";
			if(connection != null)
				pstmt=connection.prepareStatement(sqlSelectQuery);
			
			if(pstmt != null) {
				pstmt.setInt(1, empId);
				
				resultSet=pstmt.executeQuery();
				
				if(resultSet != null) {
					if(resultSet.next()) {
						employee= new Employee();
						employee.setEmpId(resultSet.getInt(1));
						employee.setEmpName(resultSet.getString(2));
						employee.setEmpAge(resultSet.getInt(3));
						employee.setEmpAddress(resultSet.getString(4));
						
						return employee;
					}
				}		
					
			}
			
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	
		return employee;
	}

	@Override
	public String updateEmployee(Integer empId, String empName, Integer empAge, String empAddress) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteEmployee(Integer empId) {
		try {
			connection=JDBCUtility.getJdbcConnection();
			String sqlDeleteQuery="delete from employeedetails where empid=?";
			if(connection != null)
				pstmt=connection.prepareStatement(sqlDeleteQuery);
			
			if(pstmt != null) {
				
				pstmt.setInt(1, empId);				
				int rowAffected=pstmt.executeUpdate();
				
				if(rowAffected == 1)
					return "success";
				else
					return "not found";
					
			}
			
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "failure";
		}		
	
		return "failure";
	}

}
