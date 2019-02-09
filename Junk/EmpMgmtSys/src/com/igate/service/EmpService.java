package com.igate.service;

import java.util.List;

import com.igate.dao.EmpDAO;
import com.igate.dto.Employee;

public class EmpService {

	public int addEmployee(Employee newEmp) {
		EmpDAO empDAO=new EmpDAO();
		return empDAO.addEmployee(newEmp);
		
	}

	public List<Employee> getEmployees() {
		EmpDAO empDAO=new EmpDAO();
		return empDAO.getEmployees();
	}

}
