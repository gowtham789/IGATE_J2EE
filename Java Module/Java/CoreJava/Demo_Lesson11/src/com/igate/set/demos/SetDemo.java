package com.igate.set.demos;

import java.util.*;



public class SetDemo {

	public static void main(String[] args) {
		HashSet<Integer> hs=new HashSet<Integer>();
		hs.add(99);
		hs.add(89);
		hs.add(55);
		hs.add(66);
		hs.add(89);
		hs.add(55);
		
		System.out.println(hs);
		
		HashSet<String> names=new HashSet<String>();
		names.add("Ram");
		names.add("Jacob");
		names.add("Zainab");
		names.add("Janvi");
		names.add("Jacob");
		System.out.println(names);
		
        HashSet<Employee> team=new HashSet<Employee>();
		
		Employee e1=new Employee(101,"Ram",78787.50f);
		Employee e2=new Employee(102,"Sita",89898.50f);
		Employee e3=new Employee(103,"Ravan",10000.50f);
		Employee e4=new Employee(104,"Ram",78787.50f);
		
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
		

	}

}
