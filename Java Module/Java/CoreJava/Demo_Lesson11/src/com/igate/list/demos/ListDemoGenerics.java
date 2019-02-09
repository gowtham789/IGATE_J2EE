package com.igate.list.demos;

import java.util.*;

public class ListDemoGenerics {

	public static void main(String[] args) {
		//List to store Integer
		/*List<Integer> marks=new ArrayList<Integer>();
		marks.add(67);
		marks.add(90);
		marks.add(34);
		
		//Add a number to position 1
		marks.add(1,88);
		System.out.println(marks);
		
		marks.add(2,48);
		marks.add(0,29);
		System.out.println(marks);
		
		//Remove element in location 2
		marks.remove(2);
		System.out.println(marks);
		
		//Remove a specific element
	
		//To iterate a collection - forEach or Iterator
		for(Integer m:marks)
		{
			System.out.println("Marks ["+m+"]");
		}
		
		//Iterator to loop through the list and delete marks <30
		
		System.out.println("-------------------------");
		System.out.println("Iterator to loop and delete mark<30");
		
		Iterator<Integer> markItr=marks.iterator();
		while(markItr.hasNext())
		{
			Integer m=markItr.next();
			if(m<30)
			{
				System.out.println("Mark is  <30 "+m+" : deleting....");
			    markItr.remove();
			}
			else
			{
				System.out.println("Mark is : "+m);
			}
			
		}
		
		System.out.println(marks);*/
		
		//List of names
		ArrayList<String> empNames=new ArrayList<String>();
		empNames.add("Ram");
		empNames.add("Lakshman");
		empNames.add("Bharath");
		empNames.add("Sita");
		empNames.add(0,"Krish");
		
		System.out.println(empNames);
		
		//List of employees
		ArrayList<Employee> team=new ArrayList<Employee>();
		
		Employee e1=new Employee(101,"Ram",78787.50f);
		Employee e2=new Employee(102,"Sita",89898.50f);
		Employee e3=new Employee(103,"Ravan",10000.50f);
		Employee e4=new Employee(101,"Laksh",90909.50f);
		
		team.add(e1);
		team.add(e2);
		team.add(e3);
		team.add(e4);
		
		for(Employee emp:team)
		{
			System.out.println(" EmpId   : "+emp.getEmpId());
			System.out.println(" EmpName : "+emp.getName());
			System.out.println(" Salary  : "+emp.getSal());
			System.out.println("___________________________");
		}
		
		System.out.println("Printing without for each");
		System.out.println(team);
		
		team.remove(2);
		for(Employee emp:team)
		{
			System.out.println(" EmpId   : "+emp.getEmpId());
			System.out.println(" EmpName : "+emp.getName());
			System.out.println(" Salary  : "+emp.getSal());
			System.out.println("___________________________");
		}
		
	}

}
