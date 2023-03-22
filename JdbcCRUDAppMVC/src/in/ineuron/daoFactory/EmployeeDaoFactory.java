package in.ineuron.daoFactory;

import in.ineuron.persistence.EmployeeDaoImpl;
import in.ineuron.persistence.IEmployeeDao;

public class EmployeeDaoFactory {

	private EmployeeDaoFactory() {
		
	}
	
	private static IEmployeeDao employeeDao=null;
	
	public static IEmployeeDao getEmployeeDao() {
		if(employeeDao == null) {
			employeeDao = new EmployeeDaoImpl();
		}
		return employeeDao;
		
	}
	
}

