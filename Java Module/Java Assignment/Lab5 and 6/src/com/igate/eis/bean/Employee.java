package com.igate.eis.bean;

public class Employee {
	
	private int empId;
	private String empName;
	private double empSal;
	private String desig;
	private String insScheme;
	
	public Employee()
	{
		
	}
	
	
	public Employee(int empId, String empName, double empSal, String desig,
			String insScheme) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empSal = empSal;
		this.desig = desig;
		this.insScheme = insScheme;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName
				+ ", empSal=" + empSal + ", desig=" + desig + ", insScheme="
				+ insScheme + "]";
	}

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

	public double getEmpSal() {
		return empSal;
	}

	public void setEmpSal(double empSal) {
		this.empSal = empSal;
	}

	public String getDesig() {
		return desig;
	}

	public void setDesig(String desig) {
		this.desig = desig;
	}

	public String getInsScheme() {
		return insScheme;
	}

	public void setInsScheme(String insScheme) {
		this.insScheme = insScheme;
	}
	
	

}
