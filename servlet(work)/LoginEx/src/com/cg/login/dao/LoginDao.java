package com.cg.login.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.cg.login.exception.LoginException;

public class LoginDao implements ILoginDao{

	@Override
	public boolean isLogin(String username, String Password)
			throws LoginException {
		Connection conn=null;
		PreparedStatement ps=null;
		int count=0;
		boolean status=false;
		try
		{
		// Register the driver
		
		// Get the connection
		InitialContext ic=new InitialContext();
		DataSource ds=(DataSource)ic.lookup("java:/jdbc/MyNewDS");
			
		conn = ds.getConnection();
		
		ps=conn.prepareStatement("select count(*) from login where username=? and password=?");
		ps.setString(1,username);
		ps.setString(2,Password);
		ResultSet rs=ps.executeQuery();
		if(rs.next())
		{
			count=rs.getInt(1);
		}
		if(count>0)
		{
			status=true;
		}
		else
		{
			status=false;
		}
		}
		catch(SQLException | NamingException e)
		{
			throw new LoginException(e.getMessage());
	}
		finally
		{
			try
			{
				conn.close();
				ps.close();
				
			}
			catch(SQLException se)
			{
				throw new LoginException("isLogin"+se.getMessage());
			}
		}return status;
	}
}
