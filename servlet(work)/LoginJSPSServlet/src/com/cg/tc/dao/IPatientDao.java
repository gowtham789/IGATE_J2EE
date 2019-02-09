package com.cg.tc.dao;

import java.util.ArrayList;

import com.cg.tc.dto.PatientDto;


public interface IPatientDao {

	boolean isLogin(String uname,String password);
	public PatientDto patientById(int pid);
	public ArrayList<PatientDto> getAllPatients();
	boolean isPatient(int id);
	int addPatientDetails(PatientDto patient);
	
}
