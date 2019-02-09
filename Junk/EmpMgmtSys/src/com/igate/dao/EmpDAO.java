package com.igate.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.igate.dto.Employee;

public class EmpDAO {

	public int addEmployee(Employee newEmp) {
		InitialContext ic;
		try {
			ic = new InitialContext();
		
		DataSource ds=(DataSource) ic.lookup("java:/jdbc/TestDS");
		Connection con=ds.getConnection();
		PreparedStatement ps=con.prepareStatement(
				"INSERT INTO emp_servlet VALUES(?,?,?,?)");
		ps.setInt(1, newEmp.getEmpid());
		ps.setString(2,newEmp.getEname());
		ps.setFloat(3,newEmp.getSalary());
		ps.setString(4,newEmp.getDesig());
		
		int count=ps.executeUpdate();
		return count;
		
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	public List<Employee> getEmployees() {
		InitialContext ic;
		List<Employee> elist=new ArrayList<Employee>();
		try {
			ic = new InitialContext();
		
		DataSource ds=(DataSource) ic.lookup("java:/jdbc/TestDS");
		Connection con=ds.getConnection();
		PreparedStatement ps=con.prepareStatement(
				"SELECT empId,ename,sal,desig FROM emp_servlet");
		ResultSet rs= ps.executeQuery();
	    while(rs.next())
	    {
	    	Employee temp=new Employee();
	    	temp.setEmpid(rs.getInt(1));
	    	temp.setEname(rs.getString(2));
	    	temp.setSalary(rs.getFloat(3));
	    	temp.setDesig(rs.getString(4));
	    	elist.add(temp);
	    }

		
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return elist;
	}

}
