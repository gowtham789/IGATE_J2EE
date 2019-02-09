package com.pms.dao;

import java.util.ArrayList;

import com.pms.dto.PatientDTO;

public interface IPatientDAO 
{
	int addPatientDetails(PatientDTO patient);
	PatientDTO getPatientDetails(int patientId);
	boolean isPatient(int patientId);
	ArrayList<PatientDTO> viewAllPatients();
}
