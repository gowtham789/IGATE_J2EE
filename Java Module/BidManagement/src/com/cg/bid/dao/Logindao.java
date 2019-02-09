package com.cg.bid.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.cg.bid.dto.BidDTO;
import com.cg.bid.service.ILogin;

public class Logindao implements ILogindao 


{

	@Override
	public boolean isValid(String username, String password) 
	{
		boolean status=false;
		Connection conn=null;
		PreparedStatement ps=null;
		int count=0;
		
		
		try
		{
			InitialContext ic=new InitialContext();
			DataSource ds=(DataSource)ic.lookup("java:/jdbc/MynewDs");
			conn=(ds).getConnection();
	        
	        ps=conn.prepareStatement("select count(*) from bidlogin where username=? and password=?");
	        ps.setString(1, username);
	        ps.setString(2, password);
	        ResultSet rs=ps.executeQuery();
	        
	        if(rs.next())
			{
			count=rs.getInt(1);
			}
	        
			if (count>0)
				
			status=true;
			
			else status=false;
		}
		catch(SQLException | NamingException se)
		{
			System.out.println(se.getMessage());
		}
		
		finally
		{
			
		}
		return status;
	}
		
	
	
	
	
	
	

	@Override
	public ArrayList<BidDTO> getAllBid() {
ArrayList<BidDTO> bids=new ArrayList<BidDTO>();
		
		//Connection to the DB
		
		Connection conn=null;
		PreparedStatement ps=null;
		try
		{
	
		InitialContext ic=new InitialContext();
		DataSource ds=(DataSource)ic.lookup("java:/jdbc/MynewDs");
		conn=(ds).getConnection();
		ps = conn.prepareStatement("SELECT * FROM biddata");

	
	    ResultSet rs=ps.executeQuery();
	
	    while(rs.next())
	    	{
	    	
	    	BidDTO bid=new BidDTO();
		    
	    	bid.setItemid(rs.getInt(1));
	    	bid.setItemname(rs.getString(2));
	    	bid.setItemprice(rs.getFloat(3));
	    	bid.setStatus(rs.getString(4));
	    	bids.add(bid);
	    	}
	    
	    
		} 
		catch (SQLException | NamingException e)
		{
			
			System.out.println(e);
		}
		finally
		{
			
		
				try {
					conn.close();
				} 
				catch (SQLException fe) 
				{
					System.out.println(fe);
				}
				try 
				{
					ps.close();
				} 
				catch (SQLException se)
				{
					System.out.println(se);
				}
			
		}
    return bids;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public BidDTO getBidbyItemid(int id) {
		
BidDTO bids=new BidDTO();
		
		//Connection to the DB
		
		Connection conn=null;
		PreparedStatement ps=null;
		try
		{
	
		InitialContext ic=new InitialContext();
		DataSource ds=(DataSource)ic.lookup("java:/jdbc/MynewDs");
		conn=(ds).getConnection();
		ps = conn.prepareStatement("SELECT * FROM biddata where itemid=?");
		
		ps.setInt(1, id);
	
	    ResultSet rs=ps.executeQuery();
	
	    while(rs.next())
	    	{
	    	bids.setItemid(rs.getInt(1));
	    	bids.setItemname(rs.getString(2));
	    	bids.setItemprice(rs.getFloat(3));
	    	bids.setStatus(rs.getString(4));
	    	
	    	}
	    
	    
		} 
		catch (SQLException | NamingException e)
		{
			
			System.out.println(e);
		}
		finally
		{
			
		
				try {
					conn.close();
				} 
				catch (SQLException fe) 
				{
					System.out.println(fe);
				}
				try 
				{
					ps.close();
				} 
				catch (SQLException se)
				{
					System.out.println(se);
				}
			
		}
    return bids;
	}

	
	
	
	
	
	
	
	@Override
	public boolean updateStatus(int id) {
		boolean flag=false;
		
		//Connection to the DB
	
			Connection conn=null;
			PreparedStatement ps=null;
			try
			{
		
			InitialContext ic=new InitialContext();
			DataSource ds=(DataSource)ic.lookup("java:/jdbc/MynewDs");
			conn=(ds).getConnection();
			
			ps=conn.prepareStatement("update biddata set status=? where itemid=?");
			ps.setString(1,"notavailable");
			ps.setInt(2, id);
			int count=ps.executeUpdate();
			
			if(count>0)
			{
				flag=true;
			}
			else
			{
				flag=false;
			}
	
			}
			catch (SQLException | NamingException e)
			{
				
				System.out.println(e);
			}
			finally
			{
					try 
					{
						conn.close();
					} 
					catch (SQLException fe) 
					{
						System.out.println(fe);
					}
					try 
					{
						ps.close();
					} 
					catch (SQLException se)
					{
						System.out.println(se);
					}
					
			}
		return flag;
	}

	
}
