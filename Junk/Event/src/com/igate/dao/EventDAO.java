package com.igate.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.igate.dto.Events;
import com.igate.dto.users;
import com.igate.exception.EventException;







public class EventDAO implements IEventDAO {

	@Override
	public ArrayList<Events> geteventType() throws EventException {
		// TODO Auto-generated method stub
		
		ArrayList<Events> event=new ArrayList<Events>();
	
		Connection conn=null;
		PreparedStatement ps=null;
		try {
			
			
			InitialContext ic=new InitialContext();
			
			DataSource ds=(DataSource)ic.lookup("java:/jdbc/mynewDS");
	
		//Connection to the DB
          conn=ds.getConnection();
		
	
			 //getting database connection
		ps = conn.prepareStatement("select * from events");   //query to insert details of patient
		 ResultSet rs=ps.executeQuery();
		while(rs.next())
	    {
			Events e=new Events();
		e.setEventid(rs.getInt(1));
	e.setEventname(rs.getString(2));
	e.setEventtype(rs.getString(3));
	e.setLocation(rs.getString(4));
	event.add(e);
		
	    }
	
	
	
	} catch (SQLException | NamingException e) {
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
	public void Adduser(users u) throws EventException {
	
		Connection conn=null;
		PreparedStatement ps=null;
	
		try {
			
			
			InitialContext ic=new InitialContext();
			
			DataSource ds=(DataSource)ic.lookup("java:/jdbc/mynewDS");
	
		//Connection to the DB
          conn=ds.getConnection();
		
	
			 //getting database connection
		ps = conn.prepareStatement("INSERT INTO users"
				+ " VALUES(?,?,?)");   //query to insert details of patient
	
	ps.setString(1, u.getName());
	ps.setString(2, u.getEventtype());
	ps.setInt(3, u.getNumofseats());
	
	
	 ps.executeUpdate();          //executing above query
	
	
	
	
	} catch (SQLException | NamingException e) {
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
	public Events byid(int id) throws EventException {
		// TODO Auto-generated method stub
		Events e=new Events();
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
	  e.setLocation(rs.getString(4));
		
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
	public int booking(Events e, users u) throws EventException {
		// TODO Auto-generated method stub
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
				+ " VALUES(?,?,bookId_Seq.nextval,?,?)");   //query to insert details of patient
	
	ps.setInt(1, e.getEventid());
	ps.setString(2,e.getEventname() );
	ps.setString(3, e.getLocation());
	ps.setInt(4, u.getNumofseats());
	
	
	ps.executeUpdate();          //executing above query
	
	Statement st=conn.createStatement();
	ResultSet rs=st.executeQuery("SELECT bookId_Seq.currval FROM dual");    //getting Patient id
	
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
