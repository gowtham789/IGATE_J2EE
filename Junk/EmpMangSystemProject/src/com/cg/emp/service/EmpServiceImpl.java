package com.cg.emp.service;

import java.util.ArrayList;

import com.cg.emp.dao.EmpDaoImpl;
import com.cg.emp.dao.IEmpDao;
import com.cg.emp.dto.Employee;
import com.cg.emp.dto.LoginDto;
import com.cg.emp.exception.EmployeeException;

public class EmpServiceImpl implements IEmpService
{
	IEmpDao empdao=new EmpDaoImpl();
	@Override
	public boolean isValidUser(LoginDto logindto) throws EmployeeException 
	{
		
		return empdao.isValidUser(logindto);
	}

	@Override
	public int getCount(String uname) throws EmployeeException 
	{
		
		return empdao.getCount(uname);
	}

	@Override
	public int generateEmpId() throws EmployeeException
	{
		
		return empdao.generateEmpId();
	}

	@Override
	public int insertEmp(Employee emp) throws EmployeeException
	{
		
		return empdao.insertEmp(emp);
	}

	@Override
	public ArrayList<Employee> getAllEmp() throws EmployeeException
	{
		
		return empdao.getAllEmp();
	}

	@Override
	public int updateEmp(Employee ee) throws EmployeeException 
	{
		
		return empdao.updateEmp(ee);
	}

	@Override
	public Employee getEmpInfo(int eid) throws EmployeeException 
	{
		
		return empdao.getEmpInfo(eid);
	}

	@Override
	public int deleteEmp(Employee ee) throws EmployeeException
	{
		
		return empdao.deleteEmp(ee);
	}

}
