package com.igate.service;

import java.util.ArrayList;

import com.igate.dto.PatientBean;
import com.igate.exception.PatientException;
public interface IPatientService
{
	int addPatientDetails(PatientBean patient) throws PatientException;
	PatientBean getPatientById(int patientId) throws PatientException;
	boolean isPatient(int patientId) throws PatientException; //checking whether patient is already exist in database
	ArrayList<PatientBean> getAllPatients() throws PatientException;
}
