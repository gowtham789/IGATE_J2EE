package com.igate.map.demo;

import java.util.HashMap;
import java.util.Set;

import com.igate.list.demos.Employee;

public class MapDemo1 {

	public static void main(String[] args) {
		HashMap<Integer,String> hm=new HashMap<Integer,String>();
		
		hm.put(101,"Hello");
		hm.put(876,"Java Script");
		hm.put(564,"Sky Blue");
		hm.put(534,"Hello");
		hm.put(876,"All is well");
		hm.put(null,"Nothing");
		
		System.out.println(hm.get(876));
		
		System.out.println("All keys and values");
		Set<Integer> keys=hm.keySet();
		for(Integer k:keys)
		{
			System.out.println(k+" : Value is :"+hm.get(k));
		}

		
		//Employee Map
		HashMap<Integer,Employee> emps=new HashMap<Integer,Employee>();
		
		Employee e1=new Employee(101,"Ram",78787.50f);
		Employee e2=new Employee(102,"Sita",89898.50f);
		Employee e3=new Employee(103,"Ravan",10000.50f);
		Employee e4=new Employee(104,"Laksh",90909.50f);
		
		emps.put(e1.getEmpId(),e1);
		emps.put(e2.getEmpId(),e2);
		emps.put(e3.getEmpId(),e3);
		emps.put(e4.getEmpId(),e4);
		
		System.out.println("-----------------------");
		System.out.println("Display employee with id 104");
		System.out.println(emps.get(104));
		
		System.out.println("All employees and values");
		Set<Integer> emp=emps.keySet();
		for(Integer e:emp)
		{
			System.out.println(e+" : Value is :"+emps.get(e));
		}
		
		System.out.println("emps.containsKey(103) ? "+emps.containsKey(103));
		
		System.out.println("Deleting..... 102");
		emps.remove(102);
		
		System.out.println("After deleting 102...");
		Set<Integer> emp1=emps.keySet();
		for(Integer e:emp1)
		{
			System.out.println(e+" : Value is :"+emps.get(e));
		}
		
		//HashMap with Key as String
		HashMap<String,Integer> markMap=new HashMap<String,Integer>();
		markMap.put("Jacob",null);
		markMap.put("Sunil",79);
		markMap.put("Suraj",null);
		markMap.put("Komal",66);
		
		System.out.println("----Mark Map----");
		System.out.println(markMap);
		
		//HashMap with Key & value as String
				HashMap<String,String> nameMap=new HashMap<String,String>();
				nameMap.put("Jacob","Chennai");
				nameMap.put("Sunil","Kerala");
				nameMap.put("Suraj","Telengana");
				nameMap.put("Komal","Andhra");
				
				System.out.println("----Name and Location Map----");
				System.out.println(nameMap);
		
		
	}

}
