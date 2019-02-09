package com.igate.objectclass.demo;

public class Student {
 public Student(int stuId, String name, int age) {
		super();
		this.stuId = stuId;
		this.name = name;
		this.age = age;
	}
@Override
public String toString() {
	return "Student [stuId=" + stuId + ", name=" + name + ", age=" + age + "]";
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
int stuId;
 String name;
 int age;
}
