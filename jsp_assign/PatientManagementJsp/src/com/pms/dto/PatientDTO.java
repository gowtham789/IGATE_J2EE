package com.pms.dto;

import java.util.Date;

public class PatientDTO
{
	private int patientId;
	private String patientName;
	private String age;
	private String phoneNum;
	private String description;
	private Date consultDate;

	public PatientDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PatientDTO(int patientId, String patientName, String age,
			String phoneNum, String description, Date consultDate) {
		super();
		this.patientId = patientId;
		this.patientName = patientName;
		this.age = age;
		this.phoneNum = phoneNum;
		this.description = description;
		this.consultDate = consultDate;
	}
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getConsultDate() {
		return consultDate;
	}
	public void setConsultDate(Date consultDate) {
		this.consultDate = consultDate;
	}
	

}
