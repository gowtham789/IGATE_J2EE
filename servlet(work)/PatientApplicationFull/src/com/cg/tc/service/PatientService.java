package com.cg.tc.service;

import java.util.ArrayList;

import com.cg.tc.dao.PatientDao;
import com.cg.tc.dto.PatientDto;

public class PatientService implements IPatientService{

	PatientDao pdao=new PatientDao();

	@Override
	public PatientDto patientById(int pid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<PatientDto> getAllPatients() {
		return pdao.getAllPatients();
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
