package com.cg.lab7.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

import com.cg.lab7.dto.Employee;

public class EmployeeService implements IEmployeeService{

		@Override
		public void getEmployee(HashMap<Integer,Employee> map,int empId,String name,float sal) {
			
			HashMap<Integer,Employee> map1=(HashMap<Integer,Employee>)map;
			map1.put(empId,new Employee(empId,name,sal,findDesig(sal),findScheme(sal)));
		}

		@Override
		public String findInsurance(HashMap<Integer,Employee> map,int id) {
			HashMap<Integer,Employee> map1=(HashMap<Integer,Employee>)map;
			Employee e=map.get(id);
			return e.getInsuranceScheme();
		}

		@Override
		public Object display(HashMap<Integer,Employee> map) {
			
			HashMap<Integer,Employee> map1=(HashMap<Integer,Employee>)map;
			return map1;
		}
		
		public void delete(HashMap<Integer,Employee> map,int id)
		{
			HashMap<Integer,Employee> map1=(HashMap<Integer,Employee>)map;
			map1.remove(id);
		}
		
		
		public ArrayList<Employee> getEmpBYScheme(HashMap<Integer,Employee> o,String scheme)
		{
			ArrayList<Employee> list=new ArrayList<Employee>();
			HashMap<Integer,Employee> map1=(HashMap<Integer,Employee>)o;
			for(Integer m:map1.keySet())
			{
				Employee e=map1.get(m);
				if((e.getInsuranceScheme()).equals(scheme))
				{
					System.out.println("hello");
					list.add(e);
				}
			}
			return list;
		}
		
		
		public HashMap<Integer,Employee> sort(HashMap<Integer,Employee> o)
		{
			HashMap<Integer,Employee> map=(HashMap<Integer,Employee>)o;
			TreeMap<Integer,Employee> tmap=new TreeMap<Integer,Employee>();
			
			//Converting the hashmap into tree map
			for(Integer m:map.keySet())
			{
				tmap.put(m,map.get(m));
			}
			
			//Again tree map converted into hashmap
			for(Integer t:tmap.keySet())
			{
				map.put(t, tmap.get(t));
			}
			return map;
		}
		
		
		private String findDesig(float sal)
		{
			float salary=sal;
			String desig="";
			if(salary>5000 && salary<20000)
			{
				desig="System Associate";
			}
			else if(salary>=2000 && salary<40000)
			{
				desig="Programmer";
			}
			else if(salary>=40000)
			{
				desig="Manager";
			}
			else
			{
				desig="Clerk";
			}
			return desig;
		}

		private String findScheme(float sal)
		{
			float salary=sal;
			String scheme="";
			if(salary>5000 && salary<20000)
			{
				scheme="Scheme A";
			}
			else if(salary>=20000 && salary<40000)
			{
				scheme="Scheme B";
			}
			else if(salary>=40000)
			{
				scheme="Scheme C";
			}
			else
			{
				scheme="No Scheme";
			}
			return scheme;
		}

	}


