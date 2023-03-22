package in.ineuron.serviceFactory;

import in.ineuron.service.EmployeeServiceImpl;
import in.ineuron.service.IEmployeeService;

//Connection connection = DriverManager.getConnection(url, userName, password)
//Abstraction logic of implementation
public class EmployeeServiceFactory {
	
	//Make constructor private to avoid object creation
	private EmployeeServiceFactory() {
		
	}
	
	private static IEmployeeService employeeService = null;
	
	public static IEmployeeService getEmployeeService() {
		
		//Singleton Pattern code
		if(employeeService == null) {
			employeeService = new EmployeeServiceImpl();
		}
		
		return employeeService;
	}
}
