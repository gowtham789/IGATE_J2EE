package com.igate.treedemos;

public class Student {
private int stuId;
public int getStuId() {
	return stuId;
}
@Override
public String toString() {
	return "Student [stuId=" + stuId + ", name=" + name + ", mark1=" + mark1
			+ ", mark2=" + mark2 + ", percentage=" + percentage + "]";
}
public Student() {
	super();
	// TODO Auto-generated constructor stub
}
public Student(int stuId, String name, int mark1, int mark2, int percentage) {
	super();
	this.stuId = stuId;
	this.name = name;
	this.mark1 = mark1;
	this.mark2 = mark2;
	this.percentage = percentage;
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
public int getMark1() {
	return mark1;
}
public void setMark1(int mark1) {
	this.mark1 = mark1;
}
public int getMark2() {
	return mark2;
}
public void setMark2(int mark2) {
	this.mark2 = mark2;
}
public int getPercentage() {
	return percentage;
}
public void setPercentage(int percentage) {
	this.percentage = percentage;
}
private String name;
private int mark1;
private int mark2;
private int percentage;
}
