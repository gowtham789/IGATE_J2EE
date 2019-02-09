package com.igate.dto;

import java.sql.Date;

public class PatientBean 
{
	private int patientId;
	private String patientName;
	private int age;
	private String phone;
	private String description;
	private Date consultDate;
	private String docName;
	
	//Default Constructor
	public PatientBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PatientBean(int patientId, String patientName, int age,
			String phone, String description, Date consultDate, String docName) {
		super();
		this.patientId = patientId;
		this.patientName = patientName;
		this.age = age;
		this.phone = phone;
		this.description = description;
		this.consultDate = consultDate;
		this.docName = docName;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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

	public String getDocName() {
		return docName;
	}

	public void setDocName(String docName) {
		this.docName = docName;
	}

	@Override
	public String toString() {
		return "PatientBean [patientId=" + patientId + ", patientName="
				+ patientName + ", age=" + age + ", phone=" + phone
				+ ", description=" + description + ", consultDate="
				+ consultDate + ", docName=" + docName + "]";
	}

	
	
	

	
	
	
	
	
	
}


