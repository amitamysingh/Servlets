 package in.ineuron.service;

import in.ineuron.daoFactory.EmployeeDaoFactory;
import in.ineuron.dto.Employee;
import in.ineuron.persistence.IEmployeeDao;

public class EmployeeServiceImpl implements IEmployeeService {
	
	IEmployeeService employeeService;
	IEmployeeDao empDao;
	
	
	@Override
	public String addEmployee(String empName, int empAge, String empAddress) {
		// TODO Auto-generated method stub
		
		
		empDao=EmployeeDaoFactory.getEmployeeDao();
		
		//employeeService = EmployeeServiceFactory.getEmployeeService();
				
			return empDao.addEmployee(empName, empAge, empAddress);
		
	}
	@Override
	public Employee searchEmployee(Integer empId) {
		// TODO Auto-generated method stub
		
		empDao=EmployeeDaoFactory.getEmployeeDao();
		
		return empDao.searchEmployee(empId);
	}

	@Override
	public String updateEmployee(Integer empId, String empName, Integer empAge, String empAddress) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteEmployee(Integer empId) {
		// TODO Auto-generated method stub
		
		empDao=EmployeeDaoFactory.getEmployeeDao();
		
		return empDao.deleteEmployee(empId);
	}

}
