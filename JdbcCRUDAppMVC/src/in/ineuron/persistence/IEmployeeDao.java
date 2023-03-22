/**
 * 
 */
package in.ineuron.persistence;

import in.ineuron.dto.Employee;

/**
 * @author shubh
 *
 */
public interface IEmployeeDao {
	
	//Operations to be implemented
	public String addEmployee(String empName, int empAge, String empAddress);
	
	public Employee searchEmployee(Integer empId);
	
	public String updateEmployee(Integer empId, String empName, Integer empAge, String empAddress);
	
	public String deleteEmployee(Integer empId);
}
