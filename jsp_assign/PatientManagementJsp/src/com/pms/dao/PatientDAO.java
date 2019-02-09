package com.pms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.pms.dto.PatientDTO;

public class PatientDAO implements IPatientDAO
{

	@Override
	public int addPatientDetails(PatientDTO patient) {
		// TODO Auto-generated method stub
		int pId=0;
		Connection conn=null;
		PreparedStatement ps=null;
		try 
		{
			InitialContext ic=new InitialContext();
			DataSource ds=(DataSource)ic.lookup("java:/jdbc/MyNewDS");
			conn=ds.getConnection();
			ps = conn.prepareStatement("INSERT INTO patient"
					+ " VALUES(patient_ID_Seq.nextval,?,?,?,?,sysdate)");

			ps.setString(1, patient.getPatientName());
			ps.setString(2, patient.getAge());
			ps.setString(3,patient.getPhoneNum());
			ps.setString(4, patient.getDescription());
			ps.executeUpdate();

			Statement st=conn.createStatement();
			ResultSet rs=st.executeQuery("SELECT patient_ID_Seq.currval FROM dual");

			if(rs.next())
			{
				pId=rs.getInt(1);
			}
			
		} catch (NamingException|SQLException e) 
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
				//Throw User defined exception here
			}
		}
		return pId;
	}

	@Override
	public PatientDTO getPatientDetails(int patientId) {
		// TODO Auto-generated method stub
		PatientDTO patient=new PatientDTO();
		Connection conn=null;
		PreparedStatement ps=null;
		try {

			InitialContext ic=new InitialContext();
			DataSource ds=(DataSource)ic.lookup("java:/jdbc/MyNewDS");
			conn=ds.getConnection();
			ps = conn.prepareStatement("Select * from patient where patient_id=?");
			ps.setInt(1, patientId);

			ResultSet rs=ps.executeQuery();

			if(rs.next())
			{
				patient.setPatientId(rs.getInt(1));
				patient.setPatientName(rs.getString(2));
				patient.setAge(rs.getString(3));
				patient.setPhoneNum(rs.getString(4));
				patient.setDescription(rs.getString(5));
				patient.setConsultDate(rs.getDate(6));
				
			}

		} catch (NamingException|SQLException e) 
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
				//Throw User defined exception here
			}
		}
		
		return patient;
	}
	
	@Override
	public boolean isPatient(int patientId)
	{
		
		Connection conn=null;
		PreparedStatement ps=null;
		int count=0;
		boolean status=false;
		try
		{
			InitialContext ic=new InitialContext();
			DataSource ds=(DataSource)ic.lookup("java:/jdbc/MyNewDS");
			conn=ds.getConnection();
			ps = conn.prepareStatement("SELECT count(*) FROM patient WHERE patient_Id=?");
			ps.setInt(1,patientId);
			ResultSet rs=ps.executeQuery();

			if(rs.next())
			{
				count=rs.getInt(1);
			}
			if (count>0)
			{
				status=true;
				
			}
			else
			{
				status=false;
				
			}
		} 
		catch (NamingException|SQLException e)
		{
			
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
				
				//Throw User defined exception here
			}
		}
		return status;
	}

	@Override
	public ArrayList<PatientDTO> viewAllPatients() {
		// TODO Auto-generated method stub
		ArrayList<PatientDTO> Patient=new ArrayList<PatientDTO>();
		Connection conn=null;
		PreparedStatement ps=null;
		try {
			InitialContext ic=new InitialContext();
			DataSource ds=(DataSource)ic.lookup("java:/jdbc/MyNewDS");
			conn=ds.getConnection();
			ps = conn.prepareStatement("SELECT * FROM patient");
			ResultSet rs=ps.executeQuery();

			while(rs.next())
			{
				PatientDTO patient=new PatientDTO();
				patient.setPatientId(rs.getInt(1));
				patient.setPatientName(rs.getString(2));
				patient.setAge(rs.getString(3));
				patient.setPhoneNum(rs.getString(4));
				patient.setDescription(rs.getString(5));
				patient.setConsultDate(rs.getDate(6));
				Patient.add(patient);
			}
		} catch (NamingException|SQLException e) {
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
				System.out.println("Get "+se.getMessage());
				//Throw User defined exception here
			}
		}
		return Patient;
	}
	
	
}
