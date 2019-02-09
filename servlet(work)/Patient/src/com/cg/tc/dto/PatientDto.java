package com.cg.tc.dto;

import java.util.Date;

public class PatientDto {

	int patientId;
	String patientName;
	int age;
	String phoneNo;
	String description;
	Date consultationDate;
	public PatientDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PatientDto(int patientId, String patientName, int age,
			String phoneNo, String description, Date consultationDate) {
		super();
		this.patientId = patientId;
		this.patientName = patientName;
		this.age = age;
		this.phoneNo = phoneNo;
		this.description = description;
		this.consultationDate = consultationDate;
	}
	public int getPatientId() {
		return patientId;
	}
	public int setPatientId(int patientId) {
		return this.patientId = patientId;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getConsultationDate() {
		return consultationDate;
	}
	public void setConsultationDate(Date consultationDate) {
		this.consultationDate = consultationDate;
	}
	@Override
	public String toString() {
		return "PatientDto [patientId=" + patientId + ", patientName="
				+ patientName + ", age=" + age + ", phoneNo=" + phoneNo
				+ ", description=" + description + ", consultationDate="
				+ consultationDate + "]";
	}
	
}
