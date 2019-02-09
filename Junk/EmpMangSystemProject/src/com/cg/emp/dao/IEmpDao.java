package com.cg.emp.dao;

import java.util.ArrayList;

import com.cg.emp.dto.Employee;
import com.cg.emp.dto.LoginDto;
import com.cg.emp.exception.EmployeeException;

public interface IEmpDao
{
	public boolean isValidUser(LoginDto logindto) throws EmployeeException;
	public int getCount(String uname) throws EmployeeException;
	public int generateEmpId() throws EmployeeException;
	public int insertEmp(Employee emp) throws EmployeeException;
	public ArrayList<Employee> getAllEmp() throws EmployeeException;
	public Employee getEmpInfo(int eid) throws EmployeeException;
	public int updateEmp(Employee ee) throws EmployeeException;
	public int deleteEmp(Employee ee) throws EmployeeException;
}
