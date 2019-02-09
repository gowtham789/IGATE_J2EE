package com.igate.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import com.igate.dto.RegisterDto;

public class RegisterDao implements IRegisterDao {
	@Override
	public String insertRegister(RegisterDto r) {
		
		String uname=null;
		Connection conn=null;
		PreparedStatement ps=null;
		PreparedStatement ps1=null;
		try {
	
		InitialContext ic=new InitialContext();
		DataSource ds=(DataSource)ic.lookup("java:/jdbc/myNewDS");
			
			
			//Connection to the DB
		conn=ds.getConnection();
		System.out.println(conn); 
		ps = conn.prepareStatement("INSERT INTO RegisteredUsers"
				+ " VALUES(?,?,?,?,?,?)");
		
		ps.setString(1, r.getfName());
		ps.setString(2, r.getlName());
		ps.setString(3, r.getPwd());
		ps.setString(4, r.getGender());
		ps.setString(5, r.getSkill());
		ps.setString(6, r.getCity());
		
		ps.executeUpdate();
		ps1=conn.prepareStatement("SELECT upper(firstname)||' '||upper(lastname) FROM RegisteredUsers where password=?");
		ps1.setString(1, r.getPwd());
		
		ResultSet rs=ps1.executeQuery();
		
		if(rs.next())
		{
			uname=rs.getString(1);
		}	
		}
		
		
		 catch (SQLException | NamingException e) {
				
			}
	
	    return uname;
		}
		
}
