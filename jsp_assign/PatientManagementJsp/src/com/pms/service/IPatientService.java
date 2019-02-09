package com.pms.service;

import java.util.ArrayList;

import com.pms.dto.PatientDTO;

public interface IPatientService 
{
	int addPatientDetails(PatientDTO patient);
	PatientDTO getPatientDetails(int patientId);
	boolean isPatient(int patientId);
	ArrayList<PatientDTO> viewAllPatients();
}
