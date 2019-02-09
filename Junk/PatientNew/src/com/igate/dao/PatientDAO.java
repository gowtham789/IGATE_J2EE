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

import com.igate.dto.PatientBean;
import com.igate.exception.PatientException;



public class PatientDAO implements IPatientDAO
{

	@Override
	
	public int addPatientDetails(PatientBean patient) throws PatientException
	{
		
		int patientId=0;
		Connection conn=null;
		PreparedStatement ps=null;
		int count=0;
		try {
			//Register the Driver	
			InitialContext ic=new InitialContext();
			DataSource ds=(DataSource)ic.lookup("java:/jdbc/mynewDS");
			conn=ds.getConnection();
		
		ps = conn.prepareStatement("INSERT INTO Patient "
				+ " VALUES(patient_ID_Seq.nextval,?,?,?,?,sysdate,?)"); //Inserting patient details into patient table
	
	
		//setting details
	ps.setString(1,patient.getPatientName()); 
	ps.setInt(2,patient.getAge());
	ps.setString(3,patient.getPhone());
	ps.setString(4,patient.getDescription());
	ps.setString(5,patient.getDocName());
	
	
	
	count=ps.executeUpdate();
	System.out.println(count);
	
	
	/*Statement st=conn.createStatement();
	ResultSet rs=st.executeQuery("SELECT patient_ID_Seq.currval FROM dual"); //selecting patientID sequence 
	
	if(rs.next())
	{
		patientId=rs.getInt(1);
	}*/
	
	//logger.info(" Patient Inserted Successfully ...."+patientId); 
	
	} catch (SQLException | NamingException e) 
		
		{
	//	logger.error("Error while Inserting details ...."+e.getMessage());
			throw new PatientException(e.getMessage());
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
				throw new PatientException(se.getMessage());
				//Throw User defined exception here
			}
		}
    return count; //returning patient id to client
	}

	@Override
	public PatientBean getPatientById(int patientId) throws PatientException 
	{
		PatientBean p=new PatientBean();
		Connection conn=null;
		PreparedStatement ps=null;
		try {
			InitialContext ic=new InitialContext();
			DataSource ds=(DataSource)ic.lookup("java:/jdbc/mynewDS");
			conn=ds.getConnection();
		
			
		ps = conn.prepareStatement("SELECT * FROM Patient "
				+ " WHERE patient_id =?"); 
		ps.setInt(1,patientId);
	
	    ResultSet rs=ps.executeQuery(); //storing in resultset 
	
	    if(rs.next()) //checking whether resultset contains values
	    {
		 p.setPatientId(rs.getInt(1));
		 p.setPatientName(rs.getString(2));
		 p.setAge(rs.getInt(3));
		 p.setPhone(rs.getString(4));
		 p.setDescription(rs.getString(5));
		 p.setConsultDate(rs.getDate(6));
	    }
	    
	
	   
	}
		catch (SQLException | NamingException e)
		{
		
			throw new PatientException(e.getMessage());
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
				throw new PatientException("Get "+se.getMessage());
				//Throw User defined exception here
			}
		}
    return p; //returning patient details
		
		
	}

	@Override
	public boolean isPatient(int patientId) throws PatientException {
		Connection conn=null;
		PreparedStatement ps=null;
		
		
		int count=0;
	
		boolean status=false;
		try {
			InitialContext ic=new InitialContext();
			DataSource ds=(DataSource)ic.lookup("java:/jdbc/mynewDS");
			conn=ds.getConnection();
			
		ps = conn.prepareStatement("SELECT count(*) FROM Patient where patient_id=?"); //selecting no of patients in patients table
		ps.setInt(1,patientId);
		ResultSet rs=ps.executeQuery();
		if(rs.next())
		{
			count=rs.getInt(1);
		}
		if (count>0)
			status=true;
		else status=false;
		} 
		catch (SQLException | NamingException e) 
		{
				throw new PatientException(e.getMessage());
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
					throw new PatientException("isValid "+se.getMessage());
					//Throw User defined exception here
				}
			}
	//	logger.info("Patient exists status :"+status);
	    return status; //returning true or false
	}
	//Getting All Patient Details
	@Override
	public ArrayList<PatientBean> getAllPatients() throws PatientException 
	{
		ArrayList<PatientBean> pb=new ArrayList<PatientBean>();
		
		//Connection to the DB
		
		Connection conn=null;
		PreparedStatement ps=null;
		try
		{
	
			InitialContext ic=new InitialContext();
			DataSource ds=(DataSource)ic.lookup("java:/jdbc/mynewDS");
			conn=ds.getConnection();
		ps = conn.prepareStatement("SELECT * FROM patient");

	
	    ResultSet rs=ps.executeQuery();
	
	    while(rs.next())
	    	{
	    	
	    	PatientBean patient=new PatientBean();
		    
	    	patient.setPatientId(rs.getInt(1));
	    	patient.setPatientName(rs.getString(2));
	    	patient.setAge(rs.getInt(3));
	    	patient.setPhone(rs.getString(4));
	    	patient.setDescription(rs.getString(5));
	    	patient.setConsultDate(rs.getDate(6));
	    	pb.add(patient);
	    	}
	    
	    
		} 
		catch (SQLException | NamingException e)
		{
			
			System.out.println(e.getMessage());
		}
		finally
		{
			try {
					conn.close();
					ps.close();
				} 
				catch (SQLException fe) 
				{
					System.out.println(fe);
				}
		}
		System.out.println(pb);
    return pb;
	}

}
