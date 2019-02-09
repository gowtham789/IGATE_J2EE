package com.igate.dto;

import java.time.LocalDate;

public class Exam {
 int examCode;
 public Exam() {
	super();
	// TODO Auto-generated constructor stub
}
public Exam(int examCode, String course, LocalDate dateOfExam) {
	super();
	this.examCode = examCode;
	this.course = course;
	this.dateOfExam = dateOfExam;
}
String course;
 LocalDate dateOfExam;
@Override
public String toString() {
	return "Exam [examCode=" + examCode + ", course=" + course
			+ ", dateOfExam=" + dateOfExam + "]";
}
public int getExamCode() {
	return examCode;
}
public void setExamCode(int examCode) {
	this.examCode = examCode;
}
public String getCourse() {
	return course;
}
public void setCourse(String course) {
	this.course = course;
}
public LocalDate getDateOfExam() {
	return dateOfExam;
}
public void setDateOfExam(LocalDate dateOfExam) {
	this.dateOfExam = dateOfExam;
}
 
}
