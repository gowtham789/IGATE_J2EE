package com.cg.reg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.cg.reg.dto.RegisterDto;
import com.cg.reg.exception.RegisterException;

public class RegisterDao implements IRegisterDao{

	@Override
	public int insertRegister(RegisterDto rdto) throws RegisterException {
		//Connection to the DB
						
			
		Connection conn=null;
		PreparedStatement ps=null;
		int count=0;
		boolean status=false;
		try
		{
		// Register the driver
		
		// Get the connection
		InitialContext ic=new InitialContext();
		System.out.println("hi 3");
		DataSource ds=(DataSource)ic.lookup("java:/jdbc/MyNewDS");
		System.out.println("hi 4");
		conn = ds.getConnection();
		System.out.println("hi 5");
		ps=conn.prepareStatement("INSERT INTO RegisteredUsers VALUES(?,?,?,?,?,?)");
		ps.setString(1,rdto.getFname());
		ps.setString(2,rdto.getLname());
		ps.setString(3,rdto.getPassword());
		ps.setString(4,rdto.getGender());
		ps.setString(5,rdto.getSkills());
		ps.setString(6, rdto.getCity());
		count=ps.executeUpdate();
		
		/*if(count>0)
		{
			status=true;
		}
		else
		{
			status=false;
		}*/
		}
		catch(SQLException | NamingException e)
		{
			throw new RegisterException(e.getMessage());
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
				throw new RegisterException("isLogin"+se.getMessage());
			}
		}
		return count;
	}

	
	
}
