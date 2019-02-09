package com.cg.tc.dao;

import com.cg.tc.dto.PatientDto;

public interface IPatientDao {

	int addPatientDetails(PatientDto patient);
	PatientDto getPatientDetails(int patientId);
	boolean isPatient(int id);
}
