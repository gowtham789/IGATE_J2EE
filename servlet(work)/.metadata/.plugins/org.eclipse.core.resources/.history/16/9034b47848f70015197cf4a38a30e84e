package com.cg.tc.service;

import java.util.ArrayList;

import com.cg.tc.dao.PatientDao;
import com.cg.tc.dto.PatientDto;

public class PatientService implements IPatientService{

	PatientDao pdao=new PatientDao();
	
	@Override
	public PatientDto patientById(int pid) {
		return pdao.patientById(pid);
	}

	@Override
	public ArrayList<PatientDto> getAllPatients() {
		return pdao.getAllPatients();
	}

	@Override
	public boolean isPatient(int id) {
		return pdao.isPatient(id);
	}

	@Override
	public int addPatientDetails(PatientDto patient) {
		// TODO Auto-generated method stub
		return 0;
	}

	

	

}
