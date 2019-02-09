package com.cg.ep.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cg.ep.dto.ExecutiveDTO;
import com.cg.ep.exception.ExecutiveException;
import com.cg.ep.util.DbConnection;




public class ExecutiveDAO implements IExecutiveDAO
{

	@Override
	public ExecutiveDTO viewById(String flight_no) throws ExecutiveException 
	{
		
		
		ExecutiveDTO pro=new ExecutiveDTO();
		Connection conn=null;
		PreparedStatement ps=null;
		try {
	
			conn = DbConnection.getConnection();
		ps = conn.prepareStatement("SELECT first_seats,buss_seats FROM flightschedule"+ " WHERE flight_no=?");
		ps.setString(1, flight_no);
	
	    ResultSet rs=ps.executeQuery();
	
	    if(rs.next())
	    {
	    	//pro.setFlight_no(rs.getString(1));
	    	//pro.setAirline(rs.getString(2));
	    	//pro.setDep_city(rs.getString(3));
	    	//pro.setArr_city(rs.getString(4));
	    	//pro.setDep_day(rs.getString(5));
	    	//pro.setArr_day(rs.getString(6));
	    	//pro.setDep_time(rs.getString(7));
	    	//pro.setArr_time(rs.getString(8));
	    	pro.setFirst_seats(rs.getInt(1));
	    	//pro.setFirst_seat_fare(rs.getInt(10));
	    	pro.setBuss_seats(rs.getInt(2));
	    	//pro.setBuss_seat_fare(rs.getInt(12));
	    	
	     }
	} catch (SQLException e) {
			throw new ExecutiveException(e.getMessage());
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
				throw new ExecutiveException("Get "+se.getMessage());
				//Throw User defined exception here
			}
		}
    return pro;
	}

	
	
	
	
	
	
	@Override
	public boolean isFlightNo(String flight_no) throws ExecutiveException 
	{
		Connection conn=null;
		PreparedStatement ps=null;
		int count=0;
		boolean status=false;
		
		try {
	
		conn = DbConnection.getConnection();
		ps = conn.prepareStatement("SELECT count(*) FROM flightschedule WHERE flight_no=?");
	
	
	ps.setString(1, flight_no);
	
	
	ResultSet rs=ps.executeQuery();
	
	
	if(rs.next())
	{
		count=rs.getInt(1);
	}
	if (count>0)
		status=true;
	else status=false;
	} 
		
		catch (SQLException e) 
		{
			throw new ExecutiveException(e.getMessage());
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
				throw new ExecutiveException("isValid "+se.getMessage());
				//Throw User defined exception here
			}
		}
		System.out.println(status);
    return status;
	}







	@Override
	public ArrayList<ExecutiveDTO> viewAllFlights() throws ExecutiveException 
			{

		ArrayList<ExecutiveDTO> flights=new ArrayList<ExecutiveDTO>();
		Connection conn=null;
		PreparedStatement ps=null;
		try {
	
			conn = DbConnection.getConnection();
		ps = conn.prepareStatement("SELECT * FROM flightschedule where dep_city=? and arr_city=?");

	
	    ResultSet rs=ps.executeQuery();
	
	    while(rs.next())
	    {
	    	ExecutiveDTO flight=new ExecutiveDTO();
	    	flight.setFlight_no(rs.getString(1));
	    	flight.setAirline(rs.getString(2));
	    	flight.setDep_city(rs.getString(3));
	    	flight.setArr_city(rs.getString(4));
	    	flight.setDep_day(rs.getString(5));
	    	flight.setArr_day(rs.getString(6));
	    	flight.setDep_time(rs.getString(7));
	    	flight.setArr_time(rs.getString(8));
	    	flight.setFirst_seats(rs.getInt(9));
	    	flight.setFirst_seat_fare(rs.getInt(10));
	    	flight.setBuss_seats(rs.getInt(11));
	    	flight.setBuss_seat_fare(rs.getInt(12));
	    		    	
	    	flights.add(flight);
	    }
	    
	                
	   
	    
	    
	} catch (SQLException e) {
			throw new ExecutiveException(e.getMessage());
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
				throw new ExecutiveException("Get "+se.getMessage());
				//Throw User defined exception here
			}
		}
		
		
    return flights;

		
	}







	public boolean isDeptime(String dtime) throws ExecutiveException {
		Connection conn=null;
		PreparedStatement ps=null;
		int count=0;
		boolean status=false;
		
		try {
	
		conn = DbConnection.getConnection();
		ps = conn.prepareStatement("SELECT count(*) FROM flightschedule WHERE dep_time=?");
	
	
	ps.setString(1, dtime);
	
	
	ResultSet rs=ps.executeQuery();
	
	
	if(rs.next())
	{
		count=rs.getInt(1);
	}
	if (count>0)
		status=true;
	else status=false;
	} 
		
		catch (SQLException e) 
		{
			throw new ExecutiveException(e.getMessage());
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
				throw new ExecutiveException("isValid "+se.getMessage());
				
			}
		}
		System.out.println(status);
    return status;
	}







	public ExecutiveDTO viewByDtime(String dtime)throws ExecutiveException {
		
		ExecutiveDTO pro=new ExecutiveDTO();
		Connection conn=null;
		PreparedStatement ps=null;
		try {
	
			conn = DbConnection.getConnection();
		ps = conn.prepareStatement("SELECT first_seats,buss_seats FROM flightschedule"+ " WHERE flight_no=?");
		ps.setString(1, dtime);
	
	    ResultSet rs=ps.executeQuery();
	
	    if(rs.next())
	    {
	    	
	    	pro.setFirst_seats(rs.getInt(1));
	    	
	    	pro.setBuss_seats(rs.getInt(2));
	    	
	    	
	     }
	} catch (SQLException e) {
			throw new ExecutiveException(e.getMessage());
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
				throw new ExecutiveException("Get "+se.getMessage());
				
			}
		}
    return pro;
	}







	public boolean isArrtime(String atime) throws ExecutiveException {
		Connection conn=null;
		PreparedStatement ps=null;
		int count=0;
		boolean status=false;
		
		try {
	
		conn = DbConnection.getConnection();
		ps = conn.prepareStatement("SELECT count(*) FROM flightschedule WHERE dep_time=?");
	
	
	ps.setString(1, atime);
	
	
	ResultSet rs=ps.executeQuery();
	
	
	if(rs.next())
	{
		count=rs.getInt(1);
	}
	if (count>0)
		status=true;
	else status=false;
	} 
		
		catch (SQLException e) 
		{
			throw new ExecutiveException(e.getMessage());
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
				throw new ExecutiveException("isValid "+se.getMessage());
				
			}
		}
		System.out.println(status);
    return status;
	}







	public ExecutiveDTO viewByAtime(String atime) throws ExecutiveException {
		ExecutiveDTO pro=new ExecutiveDTO();
		Connection conn=null;
		PreparedStatement ps=null;
		try {
	
			conn = DbConnection.getConnection();
		ps = conn.prepareStatement("SELECT first_seats,buss_seats FROM flightschedule"+ " WHERE flight_no=?");
		ps.setString(1, atime);
	
	    ResultSet rs=ps.executeQuery();
	
	    if(rs.next())
	    {
	    	
	    	pro.setFirst_seats(rs.getInt(1));
	    	
	    	pro.setBuss_seats(rs.getInt(2));
	    	
	    	
	     }
	} catch (SQLException e) {
			throw new ExecutiveException(e.getMessage());
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
				throw new ExecutiveException("Get "+se.getMessage());
				
			}
		}
    return pro;
	}







	public boolean isDepcity(String dcity) throws ExecutiveException {
		
		Connection conn=null;
		PreparedStatement ps=null;
		int count=0;
		boolean status=false;
		
		try {
	
		conn = DbConnection.getConnection();
		ps = conn.prepareStatement("SELECT count(*) FROM flightschedule WHERE dep_city=?");
	
	
	ps.setString(1, dcity);
	
	
	ResultSet rs=ps.executeQuery();
	
	
	if(rs.next())
	{
		count=rs.getInt(1);
	}
	if (count>0)
		status=true;
	else status=false;
	} 
		
		catch (SQLException e) 
		{
			throw new ExecutiveException(e.getMessage());
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
				throw new ExecutiveException("isValid "+se.getMessage());
				//Throw User defined exception here
			}
		}
		System.out.println(status);
    return status;
	}







	public ExecutiveDTO viewDepcity(String dcity) throws ExecutiveException {
		
		ExecutiveDTO city=new ExecutiveDTO();
		Connection conn=null;
		PreparedStatement ps=null;
		try {
	
			conn = DbConnection.getConnection();
		ps = conn.prepareStatement("SELECT first_seats,buss_seats FROM flightschedule"+ " WHERE dep_city=?");
		ps.setString(1, dcity);
	   
	    ResultSet rs=ps.executeQuery();
	
	    if(rs.next())
	    {
	    	
	    	city.setDep_city(rs.getString(1));
	        
	  
	    	
	    	
	     }
	} catch (SQLException e) {
			throw new ExecutiveException(e.getMessage());
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
				throw new ExecutiveException("Get "+se.getMessage());
				//Throw User defined exception here
			}
		}
    return city;
	}







	

	}


