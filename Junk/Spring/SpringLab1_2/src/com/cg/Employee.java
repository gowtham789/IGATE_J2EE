package com.cg;

public class Employee 
{
	private int employeeId;
	private String employeeName;
	private double salary;
	private int age;
	private SBU businessUnit;


	

	public Employee() {
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

	

	public SBU getBusinessUnit() {
		return businessUnit;
	}

	public void setBusinessUnit(SBU businessUnit) {
		this.businessUnit = businessUnit;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public void show()
	{
		System.out.println("*********Employee Details**********");
		System.out.println("Employee ID   	:"+employeeId);
		System.out.println("Employee Name   :"+employeeName);
		System.out.println("Employee Salary :"+salary);
		System.out.println("Employee Age    :"+age);
		System.out.println("***********************************");
		
	}
	
	public SBU getSbuDetails()
	{
		businessUnit.getSbuName();
		businessUnit.getSbuHead();
		return businessUnit;
	}

	
	
	
	
	
	
	

}
