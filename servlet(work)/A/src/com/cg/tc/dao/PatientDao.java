package com.cg.tc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.cg.tc.dto.PatientDto;
import com.cg.tc.service.PatientService;

public class PatientDao implements IPatientDao {

	int count=0;
	boolean status=false;
	
	@Override
	public PatientDto patientById(int pid) {
		PatientDto pb=new PatientDto();
		InitialContext ic;
		try {
			ic = new InitialContext();
			DataSource ds=(DataSource) ic.lookup("java:/jdbc/MyNewDS");
			Connection con=ds.getConnection();
		PreparedStatement ps = con.prepareStatement("SELECT * FROM patient where patient_id=?");
				
		ps.setInt(1,pid);
	
	    ResultSet rs=ps.executeQuery();
	
	    if(rs.next())
	    {
	    	pb.setPatientId(rs.getInt(1));
	    	pb.setPatientName(rs.getString(2));
	    	pb.setAge(rs.getInt(3));
	    	pb.setPhoneNo(rs.getString(4));
	    	pb.setDescription(rs.getString(5));
	    	pb.setConsultationDate(rs.getDate(6));
	    	
	    	
	    }
	} catch (NamingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    return pb;
	}

	@Override
	public ArrayList<PatientDto> getAllPatients() {
		ArrayList<PatientDto> patient=new ArrayList<PatientDto>();
		InitialContext ic;
		try {
			ic = new InitialContext();
			DataSource ds=(DataSource) ic.lookup("java:/jdbc/MyNewDS");
			Connection con=ds.getConnection();
		PreparedStatement ps = con.prepareStatement("SELECT * FROM patient");

	
	    ResultSet rs=ps.executeQuery();
	
	    while(rs.next())
	    {
	    	PatientDto p=new PatientDto();
	    	p.setPatientId((rs.getInt(1)));
	    	p.setPatientName((rs.getString(2)));
	    	p.setAge((rs.getInt(3)));
	    	p.setPhoneNo((rs.getString(4)));
	    	p.setDescription((rs.getString(5)));
	    	p.setConsultationDate(rs.getDate(6));
	    	
	    	patient.add(p);
	    }
	} catch (NamingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		
    return patient;
	}

	@Override
	public boolean isPatient(int id) {
		PatientDto pb=new PatientDto();
		InitialContext ic;
		
		try {
			ic = new InitialContext();
			DataSource ds=(DataSource) ic.lookup("java:/jdbc/MyNewDS");
			Connection con=ds.getConnection();
		PreparedStatement ps = con.prepareStatement("SELECT count(*) FROM patient WHERE patient_id=?");
	
	ps.setInt(1,id);
	
	
	ResultSet rs=ps.executeQuery();
	
	
	if(rs.next())
	{
		count=rs.getInt(1);
	}
	if (count>0)
		status=true;
	else status=false;
	}

		catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return status;
	}

	@Override
	public int addPatientDetails(PatientDto patient) {
		// TODO Auto-generated method stub
		return 0;
	}

	

	

}
