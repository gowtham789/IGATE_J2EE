package com.cg.tc.service;

import java.util.ArrayList;

import com.cg.tc.dao.IPatientDao;
import com.cg.tc.dao.PatientDao;
import com.cg.tc.dto.PatientDto;

public class PatientService implements IPatientService {

	PatientDao pdao=new PatientDao();
	@Override
	public PatientDto viewById(int PatientId) {
		return pdao.viewById(PatientId);
	}

	@Override
	public ArrayList<PatientDto> viewAllPatient() {
		return pdao.viewAllPatient();
	}

	@Override
	public boolean isPatient(int id) {
		return pdao.isPatient(id);
	}

}
