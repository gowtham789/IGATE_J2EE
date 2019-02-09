package com.igate.dao;

import java.util.ArrayList;

import com.igate.dto.PatientBean;
import com.igate.exception.PatientException;





public interface IPatientDAO 
{
	
	PatientBean getPatientById(int patientId) throws PatientException;
	int addPatientDetails(PatientBean patient) throws PatientException;
	ArrayList<PatientBean> getAllPatients() throws PatientException;
	public boolean isPatient(int patientId) throws PatientException;
}
