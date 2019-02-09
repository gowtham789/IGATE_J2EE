package com.cg;

public class Employee 
{
	private int employeeId;
	private String employeeName;
	private double salary;
	
	public Employee() 
	{
		super();
		// TODO Auto-generated constructor stub
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	

	
	public void show()
	{
		System.out.println("*********Employee Details**********");
		System.out.println("Employee ID   	:"+employeeId);
		System.out.println("Employee Name   :"+employeeName);
		System.out.println("Employee Salary :"+salary);
		
		System.out.println("***********************************");
		
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName="
				+ employeeName + ", salary=" + salary + "]";
	}
	
}
