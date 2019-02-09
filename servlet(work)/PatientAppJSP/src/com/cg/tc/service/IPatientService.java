package com.cg.tc.service;

import java.util.ArrayList;

import com.cg.tc.dto.PatientDto;

public interface IPatientService {

	PatientDto viewById(int PatientId);
	ArrayList<PatientDto> viewAllPatient();
	boolean isPatient(int id);
}
