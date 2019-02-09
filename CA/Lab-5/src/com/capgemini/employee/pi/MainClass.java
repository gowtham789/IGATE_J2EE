package com.capgemini.employee.pi;
import java.util.*;
import com.capgemini.employee.dto.*;
import com.capgemini.employee.service.EmployeeServiceChild;
public class MainClass {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		EmployeeServiceChild service = new EmployeeServiceChild();
		System.out.println("Enter employee Id");
		int empId = sc.nextInt();
		service.setEmpId(empId);
		System.out.println("Enter employee Name");
		String empName = sc.next();
		service.setEmpName(empName);
		System.out.println("Enter employee Salary");
		double empSal = sc.nextDouble();
		service.setEmpSal(empSal);
		System.out.println("Enter employee Designation");
		String empDesign = sc.next();
		service.setEmpDesign(empDesign);
		service.findInsucSceme();
		service.displayEmpDetails();
	}

}
