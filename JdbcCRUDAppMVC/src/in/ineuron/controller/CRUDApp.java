package in.ineuron.controller;

import java.util.Scanner;

import in.ineuron.dto.Employee;
import in.ineuron.service.IEmployeeService;
import in.ineuron.serviceFactory.EmployeeServiceFactory;

public class CRUDApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//insertOperation();
		
		//selectOperation
		//selectOperation();
		
		//deleteOperation
		
		deleteOperation();
	}

	private static void deleteOperation() {
		Scanner scanner =new Scanner(System.in);
		System.out.println("Enter the employee id:: ");
		int empId=scanner.nextInt();
		
		IEmployeeService employeeService=EmployeeServiceFactory.getEmployeeService();
		String msg=employeeService.deleteEmployee(empId);
		if(msg.equalsIgnoreCase("success")) {
			System.out.println("Record deleted successfully");
		}else if(msg.equalsIgnoreCase("not found")) {
			System.out.println("Record not found");
		}else {
			System.out.println("Record deletion failed");
		}
	}

	private static void selectOperation() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter the employee id:: ");		
		int empId = scanner.nextInt();
		
		IEmployeeService employeeService = EmployeeServiceFactory.getEmployeeService();
		Employee emp=employeeService.searchEmployee(empId);
		if(emp != null) {
			System.out.println(emp);
			System.out.println("EMPID\tEMPNAME\tEMPAGE\tEMPADDRESS");
			System.out.println(emp.getEmpId()+"\t"+emp.getEmpName()+"\t"+emp.getEmpAge()+"\t"+emp.getEmpAddress());
			
		}else {
			System.out.println("Record not found for the id:: "+empId);
		}		
		
		scanner.close();
	}

	private static void insertOperation() {
		//Connection connection=DriverManager.getConnection(url, userName, password)
		IEmployeeService employeeService = EmployeeServiceFactory.getEmployeeService();
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter the employee name:: ");		
		String empName = scanner.next();
		
		System.out.println("Enter the employee age");
		int empAge = scanner.nextInt();
		
		System.out.println("Enter the employee address:: ");		
		String empAddress = scanner.next();
		
		String msg = employeeService.addEmployee(empName, empAge, empAddress);
		if(msg.equalsIgnoreCase("success")) {
			System.out.println("Record inserted successfully");
		}else {
			System.out.println("Record insertion failed...");
		}
		scanner.close();
	}

}
