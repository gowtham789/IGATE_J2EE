package com.cg.demos;

public class EmployeeCG {

	public EmployeeCG(int empId, String empName, float salary, String desig) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.salary = salary;
		this.desig = desig;
	}
	public EmployeeCG() {
		super();
		// TODO Auto-generated constructor stub
	}
	static {
		System.out.println("Hello from static block");
	}
	private int empId;
	private String empName;
	private float salary;
	private String desig;
	private static String companyName;
	
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	public String getDesig() {
		return desig;
	}
	public void setDesig(String desig) {
		this.desig = desig;
	}
	
	public static void display()
	{
		System.out.println("Employee Details - Copyright "+companyName);    
		System.out.println("---------------------------");
	}
	public static String getCompanyName() {
		return companyName;
	}
	public static void setCompanyName(String companyName) {
		EmployeeCG.companyName = companyName;
	}
}
