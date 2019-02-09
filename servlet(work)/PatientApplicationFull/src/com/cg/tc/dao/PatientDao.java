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

	@Override
	public PatientDto patientById(int pid) {
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int addPatientDetails(PatientDto patient) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	

}
