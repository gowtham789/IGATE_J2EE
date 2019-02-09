package com.igate.service;

import java.util.ArrayList;

import com.igate.dao.PatientDAO;
import com.igate.dto.PatientBean;
import com.igate.exception.PatientException;



public class PatientService implements IPatientService{

	
	PatientDAO pdao=new PatientDAO();  //creating object for patientdao
	@Override
	public int addPatientDetails(PatientBean patient) throws PatientException {
		
		return pdao.addPatientDetails(patient);
	}

	@Override
	public PatientBean getPatientById(int patientId) throws PatientException {
		
		return pdao.getPatientById(patientId);
	}

	@Override
	public boolean isPatient(int patientId) throws PatientException {
		// TODO Auto-generated method stub
		return pdao.isPatient(patientId);
		
	}

	@Override
	public ArrayList<PatientBean> getAllPatients() throws PatientException {
		// TODO Auto-generated method stub
		return pdao.getAllPatients();
	}
	
	

}
