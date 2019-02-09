package com.cg.lab7.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.cg.lab7.dto.Employee;

public interface IEmployeeService {
		
		public void getEmployee(HashMap<Integer,Employee> o,int empId,String name,float sal);
		public String findInsurance(HashMap<Integer,Employee> o,int id);
		public Object display(HashMap<Integer,Employee> o);
		public void delete(HashMap<Integer,Employee> o,int id);
		public HashMap<Integer,Employee> sort (HashMap<Integer,Employee> o);
		public ArrayList<Employee> getEmpBYScheme(HashMap<Integer,Employee> o,String scheme);

	}



