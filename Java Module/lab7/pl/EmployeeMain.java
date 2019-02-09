package com.cg.lab7.pl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import com.cg.lab7.dto.Employee;
import com.cg.lab7.exception.EmployeeException;
import com.cg.lab7.service.EmployeeService;
import com.cg.lab7.service.IEmployeeService;

public class EmployeeMain {


		public static void main(String args[])
		{
				char choice='N';
				IEmployeeService ie=new EmployeeService();
				Scanner sc=new Scanner(System.in);
				HashMap<Integer,Employee> map=new HashMap<Integer,Employee>();
				try
				{
					do
					{
					System.out.println("Enter Your Name : ");
					String name=sc.next();
					System.out.println("Enter Your EmpId : ");
					int id=sc.nextInt();
					System.out.println("Enter Your Salary : ");
					float sal=sc.nextInt();
					if(sal<3000)
					{
						EmployeeException ee=new EmployeeException("Salary should be greater than 3000");
						throw ee;
					}
					ie.getEmployee(map,id,name,sal);
					System.out.println("Do You want to enter more records if Yes press 'y' or 'Y'");
					choice=sc.next().charAt(0);
					}
					while(choice=='Y'||choice=='y');
				
					HashMap result=(HashMap)ie.display(map);
					System.out.println(result);
					
					System.out.println("Enter empId for finding Scheme");
					int id=sc.nextInt();
					String scheme=ie.findInsurance(map,id);
					System.out.println("Your Scheme is : "+scheme);
				
					
					System.out.println("Enter empId for deletion");
					int delId=sc.nextInt();
					ie.delete(map,delId);
				
					System.out.println("After Deleting");
					HashMap result1=(HashMap)ie.display(map);
					System.out.println(result1);
					
					HashMap<Integer,Employee> smap=(HashMap<Integer,Employee>)ie.sort(map);
					System.out.println("After Sorting");
					HashMap sort=(HashMap)ie.display(smap);
					System.out.println(sort);
					
					System.out.println("Enter Scheme for retriving employee");
					ArrayList<Employee> list=(ArrayList<Employee>)ie.getEmpBYScheme(map,sc.next());
					System.out.println("Results Are..........");
					System.out.println(list);
										
				}
				catch(EmployeeException ee)
				{
					System.out.println(ee.getMessage());
				}
				finally
				{
					sc.close();
				}
			}
}

