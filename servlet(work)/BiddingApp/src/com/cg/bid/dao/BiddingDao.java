package com.cg.bid.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.cg.bid.dto.BiddingDto;

public class BiddingDao implements IBiddingDao {

	@Override
	public boolean isLogin(String username, String Password) {
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
			System.out.println(e.getMessage());
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
				System.out.println(se.getMessage());
			}
		}return status;
	}

	@Override
	public ArrayList<BiddingDto> getItems() {
		InitialContext ic;
		ArrayList<BiddingDto> elist=new ArrayList<BiddingDto>();
		try {
			ic = new InitialContext();
		
		DataSource ds=(DataSource) ic.lookup("java:/jdbc/MyNewDS");
		Connection con=ds.getConnection();
		PreparedStatement ps=con.prepareStatement("SELECT * from itemsforbid");
		ResultSet rs= ps.executeQuery();
	    while(rs.next())
	    {
	    	BiddingDto bdto=new BiddingDto();
	    	bdto.setItemId(rs.getInt(1));
	    	bdto.setItemName(rs.getString(2));
	    	bdto.setItemPrice(rs.getFloat(3));
	    	bdto.setStatus(rs.getString(4));
	    	elist.add(bdto);
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

	@Override
	public BiddingDto viewById(int itemid) {
		BiddingDto bdto=new BiddingDto();
		InitialContext ic;
		Connection conn=null;
		PreparedStatement ps=null;
		try {
			ic = new InitialContext();
			DataSource ds=(DataSource) ic.lookup("java:/jdbc/MyNewDS");
			conn=(ds).getConnection();
			ps = conn.prepareStatement("SELECT * FROM itemsforbid where itemid=?");
				
		ps.setInt(1,itemid);
	
	    ResultSet rs=ps.executeQuery();
	
	    while(rs.next())
	    {
	    	bdto.setItemId(rs.getInt(1));
	    	bdto.setItemName(rs.getString(2));
	    	bdto.setItemPrice(rs.getFloat(3));
	    	bdto.setStatus(rs.getString(4));
	    	
	    }
	} catch (SQLException | NamingException e) {
			System.out.println(e.getMessage());
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
				System.out.println(se.getMessage());
				
			}
		}
    return bdto;
	}

	@Override
	public boolean updateStatus(int id) {
		boolean status=false;
		Connection conn=null;
		PreparedStatement ps=null;
		try {
			InitialContext ic = new InitialContext();
			DataSource ds=(DataSource) ic.lookup("java:/jdbc/MyNewDS");
			conn=(ds).getConnection();
			ps = conn.prepareStatement("update itemsforbid set status=? where itemid=?");
			ps.setString(1,"notava");
			ps.setInt(2,id);
			int count=ps.executeUpdate();
			if(count>0)
			{
				status=true;
			}
			else
			{
				status=false;
			}
		}
			catch (SQLException | NamingException e) {
				System.out.println(e.getMessage());
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
				System.out.println(se.getMessage());
				
			}
		}
		return status;
		}
		
	}
