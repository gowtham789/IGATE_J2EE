package com.cg.ctlr;

import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.NotEmpty;

public class Employee 
{
	private int empId;
	
	
	private String name;
	
	
	private String dob;
	
	
	private float salary;
	

	private String location;
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	
	@NotEmpty(message="Please Enter employee Name")
	@Pattern(regexp = "^[a-zA-Z]+$", message = "Username must contain only alphabets")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@NotEmpty(message="Please Enter employee Date of birth")
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}

	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	
	@NotEmpty(message="Please Enter Location")
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", DOB=" + dob
				+ ", salary=" + salary + ", location=" + location + "]";
	}

	
	
	

}
