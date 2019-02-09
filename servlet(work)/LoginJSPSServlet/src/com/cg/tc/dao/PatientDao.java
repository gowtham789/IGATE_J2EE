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
	public boolean isLogin(String uname, String password) {
		PatientDto pb=new PatientDto();
		int count = 0;
		boolean status = false;
		InitialContext ic;
		try {
			ic = new InitialContext();
			DataSource ds=(DataSource) ic.lookup("java:/jdbc/MyNewDS");
			Connection con=ds.getConnection();
		
		PreparedStatement ps=con.prepareStatement("select count(*) from login where username=? and password=?");
		ps.setString(1,uname);
		ps.setString(2,password);
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
		catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}return status;
	}
	
	@Override
	public PatientDto patientById(int pid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<PatientDto> getAllPatients() {
		// TODO Auto-generated method stub
		return null;
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
