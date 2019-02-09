package com.cg.tc.dao;

import java.util.ArrayList;

import com.cg.tc.dto.PatientDto;

public interface IPatientDao {

	PatientDto viewById(int PatientId);
	ArrayList<PatientDto> viewAllPatient();
	boolean isPatient(int id);
}
