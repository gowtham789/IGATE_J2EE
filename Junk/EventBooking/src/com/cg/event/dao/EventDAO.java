package com.cg.event.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.cg.event.dto.EventsDTO;
import com.cg.event.dto.UsersDTO;
import com.cg.event.exception.EventException;

public class EventDAO implements IEventDAO
{

	@Override
	public ArrayList<EventsDTO> getEventType() throws EventException
	{
		
		ArrayList<EventsDTO> event=new ArrayList<EventsDTO>();
		
		Connection conn=null;
		PreparedStatement ps=null;
		try 
		{
			
			
			InitialContext ic=new InitialContext();
			DataSource ds=(DataSource)ic.lookup("java:/jdbc/mynewDS");
			conn=ds.getConnection();
		
	
			 //getting database connection
			ps = conn.prepareStatement("select * from events");   
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				EventsDTO e=new EventsDTO();
				e.setEventid(rs.getInt(1));
				e.setEventname(rs.getString(2));
				e.setEventtype(rs.getString(3));
				e.setLocation(rs.getString(4));
			
				event.add(e);
		
			}
			
		 } 
		catch (SQLException | NamingException e) 
		{
			throw new EventException(e.getMessage());
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
				throw new EventException(se.getMessage());
				//Throw User defined exception here
			}
		}

		return event;
	}

	@Override
	public void addUser(UsersDTO u) throws EventException 
	{
		Connection conn=null;
		PreparedStatement ps=null;
	
		try {
			
			
		InitialContext ic=new InitialContext();
		DataSource ds=(DataSource)ic.lookup("java:/jdbc/mynewDS");
		conn=ds.getConnection();
		
	
			 //getting database connection
		ps = conn.prepareStatement("INSERT INTO users"
				+ " VALUES(?,?,?)");   //query to insert details of patient
	
	ps.setString(1, u.getName());
	ps.setString(2, u.getEventtype());
	ps.setInt(3, u.getNumofseats());
	
	
	 ps.executeUpdate();          //executing above query
	
	
	
	
	} 
	catch (SQLException | NamingException e)
		{
			throw new EventException(e.getMessage());
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
				throw new EventException(se.getMessage());
				//Throw User defined exception here
			}
		}
		
	}

	@Override
	public EventsDTO getById(int id) throws EventException {
		EventsDTO e=new EventsDTO();
		Connection conn=null;
		PreparedStatement ps=null;
		try {
			InitialContext ic=new InitialContext();
			
			DataSource ds=(DataSource)ic.lookup("java:/jdbc/mynewDS");
	
		//Connection to the DB
          conn=ds.getConnection();
		
			
		ps = conn.prepareStatement("SELECT * FROM events WHERE eventid=?");   //query to retrieve details of patient by id
		ps.setInt(1, id);
	
	    ResultSet rs=ps.executeQuery();    //executing above query
	   
	    if(rs.next())
	    {
	    	e.setEventid(rs.getInt(1));
	    	e.setEventname(rs.getString(2));
	    	e.setLocation(rs.getString(3));
		
	    }
	   
	} catch (SQLException | NamingException e1) {
			throw new EventException(e1.getMessage());
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
				throw new EventException("Get "+se.getMessage());
				//Throw User defined exception here
			}
		}
		
		return e;
	}

	@Override
	public int getBooking(EventsDTO e, UsersDTO u) throws EventException 
	{
		int bid=0;
		Connection conn=null;
		PreparedStatement ps=null;
		try {
			
			
			InitialContext ic=new InitialContext();
			
			DataSource ds=(DataSource)ic.lookup("java:/jdbc/mynewDS");
	
		//Connection to the DB
          conn=ds.getConnection();
		
	
			 //getting database connection
		ps = conn.prepareStatement("INSERT INTO booking"
				+ " VALUES(?,?,book_seq.nextval,?,?)");   //query to insert details of patient
	
	ps.setInt(1, e.getEventid());
	ps.setString(2,e.getEventname());
	ps.setString(3, e.getLocation());
	ps.setInt(4, u.getNumofseats());
	
	
	ps.executeUpdate();          //executing above query
	
	Statement st=conn.createStatement();
	ResultSet rs=st.executeQuery("SELECT book_seq.currval FROM dual");    //getting Patient id
	
	if(rs.next())
	{
		bid=rs.getInt(1);      
	
		
	}
	} catch (SQLException | NamingException e3) {
			throw new EventException(e3.getMessage());
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
				throw new EventException(se.getMessage());
				//Throw User defined exception here
			}
		}
    return bid;
		
		
		
	}

}
