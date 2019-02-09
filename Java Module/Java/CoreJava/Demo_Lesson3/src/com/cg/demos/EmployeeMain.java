package com.cg.demos;

public class EmployeeMain {

	public static void main(String[] args) {
		
		//Company Name is static assigning value to it
		EmployeeCG.setCompanyName("Capgemini");
		EmployeeCG.display();
		//Create an Employee
		
		EmployeeCG e1=new EmployeeCG();
		e1.setEmpId(677);
		e1.setEmpName("Shiv");
		e1.setSalary(67777.50f);
		e1.setDesig("TL");

		System.out.println("Employee Details");
		System.out.println("----------------");
		System.out.println(" Id    :"+e1.getEmpId());
		System.out.println(" Name  :"+e1.getEmpName());
		System.out.println(" Salary:"+e1.getSalary());
		System.out.println(" Desig :"+e1.getDesig());
		System.out.println(" The Company Name is  :"+EmployeeCG.getCompanyName());
	

		EmployeeCG e2=new EmployeeCG(90,"Anu",787878f,"TL");
		
	/*	EmployeeCG e2=new EmployeeCG();
		e2.setEmpId(888);
		e2.setEmpName("Vish");
		e2.setSalary(455466.50f);
		e2.setDesig("PM");*/
		
		System.out.println("Employee Details");
		System.out.println("----------------");
		System.out.println(" Id    :"+e2.getEmpId());
		System.out.println(" Name  :"+e2.getEmpName());
		System.out.println(" Salary:"+e2.getSalary());
		System.out.println(" Desig :"+e2.getDesig());
		System.out.println(" The Company Name is  :"+EmployeeCG.getCompanyName());

		long l1=90;
		
		int n1=(int)l1;
	}

}
