package com.capgemini.employee.service;
import com.capgemini.employee.dto.*;
public class EmployeeServiceChild extends Employee implements EmployeeService{

	@Override
	public void getEmpDetails() {
		super.getEmpDesign();
		super.getEmpId();
		super.getEmpName();
		super.getEmpSal();
		
	}

	@Override
	public void findInsucSceme() {
		double sal = super.getEmpSal();
		String design = super.getEmpDesign();
		if(sal>5000 && sal<20000 && design.equals("System Associate"))
			super.setInsSch("Scheme C");
		else if(sal>=20000 && sal<40000 && design.equals("Programmer"))
			super.setInsSch("Scheme B");
		else if(sal>=40000 && design.equals("Manager"))
			super.setInsSch("Scheme A");
		else if(sal<5000 && design.equals("Clerk"))
			super.setInsSch("No Scheme");
		else
			super.setInsSch("Invalid");
	}

	@Override
	public void displayEmpDetails() {
		System.out.println("Emp name " +super.getEmpName());
		System.out.println("Emp Id "+super.getEmpId());
		System.out.println("Emp Sal "+super.getEmpSal());
		System.out.println("Emp Desing "+super.getEmpDesign());
		System.out.println("Emp Scheme "+super.getInsSch());
		
	}
	
}
