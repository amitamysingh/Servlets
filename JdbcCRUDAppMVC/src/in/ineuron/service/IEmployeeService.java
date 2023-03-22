package in.ineuron.service;

import in.ineuron.dto.Employee;

public interface IEmployeeService {
	
	//Operations to be implemented
		public String addEmployee(String empName, int empAge, String empAddress);
		
		public Employee searchEmployee(Integer empId);
		
		public String updateEmployee(Integer empId, String empName, Integer empAge, String empAddress);
		
		public String deleteEmployee(Integer empId);
		
}
