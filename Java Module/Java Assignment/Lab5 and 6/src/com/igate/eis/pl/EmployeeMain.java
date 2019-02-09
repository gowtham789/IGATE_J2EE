package com.igate.eis.pl;

import java.util.Scanner;
import java.util.regex.Pattern;

import com.igate.eis.bean.Employee;
import com.igate.eis.exception.EmployeeException;
import com.igate.eis.service.EmployeeService;
import com.igate.eis.service.IEmpService;


public class EmployeeMain {

	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		
		Employee e1=new Employee();
		//create employee object
		System.out.println("------Student 1------");
        String idPattern = "[1-9][0-9]{2}";
        while (true)
        {
			System.out.println("Enter the Employee ID  - 3 digits only");
			int idTemp = sc.nextInt();
			if (Pattern.matches(idPattern, String.valueOf(idTemp))) {
				e1.setEmpId(idTemp);
				break;
			} 
			else
			{
				System.err.println("Please enter a 3 digit number");
			}
		}

		String namePattern = "[A-Z][a-z]+";
		while (true) {
			System.out.println("Enter the Employee Name");
			String nameTemp = sc.next();

			if (Pattern.matches(namePattern, nameTemp)) {
				e1.setEmpName(nameTemp);
				break;
			} else {
				System.err.println("Please valid name starting with Caps:");
			}
		}
		
		System.out.println("Enter the salary of employee");
		double sal=sc.nextDouble();
		
		//Raising exception when salary less than 3000
		
		try
		{
			if(sal<3000)
			{
				EmployeeException empex=new EmployeeException("Salary should not be below 3000");
				throw empex;
			}
		}
		catch(EmployeeException ag)
		{
			System.err.println(ag.getMessage());
		}
		
		e1.setEmpSal(sal);
		
		System.out.println("Enter the designation of employee");
		String des=sc.next();
		e1.setDesig(des);
		
		
		
		//Displaying employee details
		
		System.out.println("------------Employee Details-----------");
		System.out.println("Employee Name :"+e1.getEmpName());
		System.out.println("Employee ID :"+e1.getEmpId());
		System.out.println("Employee Salary :"+e1.getEmpSal());
		System.out.println("Employee Designation :"+e1.getDesig());
		IEmpService ser=new EmployeeService();
	    String scheme=ser.calcInsScheme(e1); //calling service method for getting insurance scheme
	    System.out.println("Insurance Scheme:"+scheme);
	    System.out.println("----------------------------------------");
	    sc.close();
	    }

}
