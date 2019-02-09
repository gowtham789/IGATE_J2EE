package com.pms.service;

import java.util.ArrayList;

import com.pms.dao.PatientDAO;
import com.pms.dto.PatientDTO;

public class PatientService implements IPatientService 
{
	PatientDAO pd=new PatientDAO();
	@Override
	public int addPatientDetails(PatientDTO patient) {
		// TODO Auto-generated method stub
		return pd.addPatientDetails(patient);
	}

	@Override
	public PatientDTO getPatientDetails(int patientId) {
		// TODO Auto-generated method stub
		return pd.getPatientDetails(patientId);
	}

	@Override
	public boolean isPatient(int patientId) {
		// TODO Auto-generated method stub
		return pd.isPatient(patientId);
	}

	@Override
	public ArrayList<PatientDTO> viewAllPatients() {
		// TODO Auto-generated method stub
		return pd.viewAllPatients();
	}


}
