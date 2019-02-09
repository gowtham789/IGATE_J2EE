package com.igate.treedemos;

import java.util.HashSet;
import java.util.TreeSet;


public class TreeMain {

	public static void main(String[] args) {
		TreeSet<Integer> hs=new TreeSet<Integer>();
		hs.add(99);
		hs.add(89);
		hs.add(55);
		hs.add(66);
		hs.add(89);
		hs.add(55);
		
		System.out.println(hs);
		
		TreeSet<String> names=new TreeSet<String>();
		names.add("Ram");
		names.add("Jacob");
		names.add("Zainab");
		names.add("Janvi");
		names.add("Jacob");
		System.out.println(names);
		
		
		TreeSet<Employee> team=new TreeSet<Employee>();
		
		Employee e1=new Employee(555,"Ram",78787.50f);
		Employee e2=new Employee(222,"Sita",89898.50f);
		Employee e3=new Employee(103,"Karthik",10000.50f);
		Employee e4=new Employee(222,"Abi",78787.50f);
		
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
