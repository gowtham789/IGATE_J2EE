package com.cg.emp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import sun.security.pkcs11.Secmod.DbMode;

import com.cg.emp.dto.Employee;
import com.cg.emp.dto.LoginDto;
import com.cg.emp.exception.EmployeeException;
import com.cg.emp.util.EmployeeUtil;

public class EmpDaoImpl implements IEmpDao
{
	Connection con;
	Statement st;
	PreparedStatement pst;
	ResultSet rs;
	Employee emp;
	@Override
	public boolean isValidUser(LoginDto logindto) throws EmployeeException
	{
		boolean flag=false;
		con=EmployeeUtil.getConnection();
		String validUserQry="SELECT * FROM myuser where uname=?";
		
		try 
		{
				pst=con.prepareStatement(validUserQry);
				pst.setString(1, logindto.getUname());
				rs=pst.executeQuery();
				rs.next();
				String un=rs.getString("uname");
				String pw=rs.getString("password");
				if(pw.equalsIgnoreCase(logindto.getPassword()))
				{	flag=true;
				}
			
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
			throw new EmployeeException(e.getMessage());
		}
		finally
		{
			try 
			{
				pst.close();
				con.close();
			} 
			catch (SQLException e)
			{
				e.printStackTrace();
				throw new EmployeeException(e.getMessage());
			}
		}
		
		
		return flag;
	}

	@Override
	public int getCount(String uname) throws EmployeeException
	{
		con=EmployeeUtil.getConnection();
		String countQry="SELECT COUNT(*) FROM myuser WHERE uname=?";
		int rowCount=0;
		try
		{
			pst=con.prepareStatement(countQry);
			pst.setString(1, uname);
			rs=pst.executeQuery();
			rs.next();
			rowCount=rs.getInt(1);
		} 
		catch (SQLException e) 
		{
			
			e.printStackTrace();
			throw new EmployeeException(e.getMessage());
		}
		finally
		{
			try 
			{
				pst.close();
				con.close();
			} 
			catch (SQLException e)
			{
				e.printStackTrace();
				throw new EmployeeException(e.getMessage());
			}
		}
		return rowCount;
	}

	@Override
	public int generateEmpId() throws EmployeeException
	{
		con=EmployeeUtil.getConnection();
		String empIdQry="SELECT seq_emp.NEXTVAL FROM dual";
		System.out.println("in dao generate empid***");
		int generatedEmpId=0;
		try 
		{
			st=con.createStatement();
			rs=st.executeQuery(empIdQry);
			rs.next();
			generatedEmpId=rs.getInt(1);
		} 
		catch (SQLException e) 
		{
			
			e.printStackTrace();
		}
		finally 
		{
			try
			{
				rs.close();
				st.close();
				con.close();
			} 
			catch (SQLException e) 
			{
				
				e.printStackTrace();
			}
			
		}
		return generatedEmpId;
	}

	@Override
	public int insertEmp(Employee emp) throws EmployeeException 
	{
		con=EmployeeUtil.getConnection();
		int dataInserted = 0;
		String insertEmpQry="INSERT INTO employee414 VALUES(?,?,?)";
		try
		{
			pst=con.prepareStatement(insertEmpQry);
			pst.setInt(1, emp.getEid());
			pst.setString(2, emp.getEname());
			pst.setInt(3, emp.getSal());
			dataInserted = pst.executeUpdate();
			System.out.println("data inserted in table");
		} 
		catch (SQLException e) 
		{
			
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				pst.close();
				con.close();
			} 
			catch (SQLException e)
			{
				
				e.printStackTrace();
			}
			
		}
		return dataInserted;
	}

	@Override
	public ArrayList<Employee> getAllEmp() throws EmployeeException 
	{
		con=EmployeeUtil.getConnection();
		String selectAllEmpQry="SELECT * FROM employee414";
		ArrayList<Employee> empList=new ArrayList<Employee>();
		try 
		{
			st=con.createStatement();
			rs=st.executeQuery(selectAllEmpQry);
			while(rs.next())
			{
				Employee em=new Employee(rs.getInt(1),rs.getString(2),rs.getInt(3));
				empList.add(em);
			}
		} 
		catch (SQLException e) 
		{
			
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				rs.close();
				st.close();
				con.close();
			} 
			catch (SQLException e) 
			{
				
				e.printStackTrace();
			}
		}
		
		return empList;
	}

	@Override
	public Employee getEmpInfo(int eid) throws EmployeeException 
	{
		con=EmployeeUtil.getConnection();
		String selQry="SELECT * FROM employee414 WHERE eid=?";
		try
		{
			pst=con.prepareStatement(selQry);
			pst.setInt(1, eid);
			rs=pst.executeQuery();
			rs.next();
			emp=new Employee(rs.getInt(1),rs.getString(2),rs.getInt(3));
		} 
		catch (SQLException e)
		{
			try
			{
				rs.close();
				pst.close();
				con.close();
			} 
			catch (SQLException e1) 
			{
				e1.printStackTrace();
			}
			
			e.printStackTrace();
		}
		
		return emp;
	}

	@Override
	public int updateEmp(Employee ee) throws EmployeeException 
	{
		con= EmployeeUtil.getConnection();
		int dataUpdated=0;
		String updateEmpQry="UPDATE employee414 SET ename=?,sal=? WHERE eid=?";
		try 
		{
			pst=con.prepareStatement(updateEmpQry);
			pst.setString(1, ee.getEname());
			pst.setInt(2,ee.getSal() );
			pst.setInt(3, ee.getEid());
			dataUpdated = pst.executeUpdate();
			System.out.println("in dao data updated...");
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return dataUpdated;
	}

	@Override
	public int deleteEmp(Employee ee) throws EmployeeException 
	{
		con= EmployeeUtil.getConnection();
		int dataDeleted=0;
		String updateEmpQry="DELETE FROM employee414 WHERE eid=?";
		try 
		{
			pst=con.prepareStatement(updateEmpQry);
			
			pst.setInt(1, ee.getEid());
			dataDeleted = pst.executeUpdate();
			System.out.println("in dao data deleted...");
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return dataDeleted;
		
	}

}
