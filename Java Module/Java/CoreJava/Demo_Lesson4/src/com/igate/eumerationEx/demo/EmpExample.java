package com.igate.eumerationEx.demo;

public class EmpExample {

	public static void main(String[] args) {
		Emp e1=new Emp();
		
		e1.empId=6777;
		e1.empName="Udhay";
		e1.loc=Location.HYDERABAD;
		
		System.out.println("Employee works at :"+e1.loc);
		System.out.println("Number of projects :"+e1.loc.noOfProjects);

	}

}
