package com.cg.reg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.cg.reg.dto.RegisterDto;
import com.cg.reg.exception.RegisterException;

public class RegisterDao implements IRegisterDao{

	@Override
	public String insertRegister(RegisterDto rdto) throws RegisterException {
		//Connection to the DB
						
			
		Connection conn=null;
		PreparedStatement ps=null;
		PreparedStatement ps1=null;
		String result=null;
		boolean status=false;
		ResultSet rs=null;
		try
		{
		// Register the driver
		
		// Get the connection
		InitialContext ic=new InitialContext();
		
		DataSource ds=(DataSource)ic.lookup("java:/jdbc/MyNewDS");
		
		conn = ds.getConnection();
	
		ps=conn.prepareStatement("INSERT INTO RegisteredUsers VALUES(?,?,?,?,?,?)");
		ps.setString(1,rdto.getFname());
		ps.setString(2,rdto.getLname());
		ps.setString(3,rdto.getPassword());
		ps.setString(4,rdto.getGender());
		ps.setString(5,rdto.getSkills());
		ps.setString(6, rdto.getCity());
		ps1=conn.prepareStatement("SELECT firstname FROM RegisteredUsers WHERE password=?");
		ps1.setString(1,rdto.getPassword());
		rs=ps1.executeQuery();
		if(rs.next())
		{
			result=rs.getString(1);
		}
		
		else
		{
			status=false;
		}
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
		return result;
	}

	
	
}
