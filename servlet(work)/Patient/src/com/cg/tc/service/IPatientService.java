package com.cg.tc.service;

import com.cg.tc.dto.PatientDto;

public interface IPatientService {

	int addPatientDetails(PatientDto patient);
	PatientDto getPatientDetails(int patientId);
	boolean isPatient(int id);
}
