package com.cg.emp.util;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.cg.emp.exception.EmployeeException;


public class EmployeeUtil 
{
	//private static final Logger mylogger=Logger.getLogger(EmployeeUtil.class);
	public static Connection getConnection() throws EmployeeException
	{
		InitialContext ic;
		Connection con;
		int i = 0;
		try
		{
			ic = new InitialContext();
			DataSource ds=(DataSource) ic.lookup("java:/jdbc/testDS");
			con=ds.getConnection();
		}
		catch(SQLException | NamingException e)
		{
			throw new EmployeeException("error in connection");
		}
		return con;
	}
}
