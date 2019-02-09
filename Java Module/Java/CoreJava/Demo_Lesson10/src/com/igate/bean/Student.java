package com.igate.bean;

public class Student {
 int stuId;
 String name;
 String course;
 float aggregate;
public Student(int stuId, String name, String course, float aggregate) {
	super();
	this.stuId = stuId;
	this.name = name;
	this.course = course;
	this.aggregate = aggregate;
}
public Student() {
	super();
	// TODO Auto-generated constructor stub
}
public int getStuId() {
	return stuId;
}
public void setStuId(int stuId) {
	this.stuId = stuId;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getCourse() {
	return course;
}
public void setCourse(String course) {
	this.course = course;
}
public float getAggregate() {
	return aggregate;
}
public void setAggregate(float aggregate) {
	this.aggregate = aggregate;
}
@Override
public String toString() {
	return "Student [stuId=" + stuId + ", name=" + name + ", course=" + course
			+ ", aggregate=" + aggregate + "]";
}
 
}
