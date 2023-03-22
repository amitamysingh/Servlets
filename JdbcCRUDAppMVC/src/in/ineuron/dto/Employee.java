package in.ineuron.dto;

import java.io.Serializable;

public class Employee implements Serializable{
	
	public static final long serialVersionUID=1L;
	
	private Integer empId;
	private String empName;
	private Integer empAge;
	private String empAddress;
	
	public Integer getEmpId() {
		return empId;
	}
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public Integer getEmpAge() {
		return empAge;
	}
	public void setEmpAge(Integer empAge) {
		this.empAge = empAge;
	}
	public String getEmpAddress() {
		return empAddress;
	}
	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empAge=" + empAge + ", empAddress=" + empAddress
				+ "]";
	}
	
	
}
