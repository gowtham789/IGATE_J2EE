package com.cg.tc.service;

import com.cg.tc.dao.PatientDao;
import com.cg.tc.dto.PatientDto;

public class PatientService implements IPatientService{

	PatientDao pdao=new PatientDao();
	@Override
	public int addPatientDetails(PatientDto patient) {
		return pdao.addPatientDetails(patient);
	}

	@Override
	public PatientDto getPatientDetails(int patientId) {
		return pdao.getPatientDetails(patientId);
	}

	@Override
	public boolean isPatient(int id) {
		return pdao.isPatient(id);
	}

}
