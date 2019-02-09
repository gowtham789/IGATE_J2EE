package com.igate.inherit;

public class Student extends Person{
 int percentage;
 int stuId;
 
 public Student()
 {
	 super();
	 this.percentage=89;
	 this.stuId=72;	 
 }

 public Student(String name,int age,int percent,int id)
 {
	 super(name,age);
	 this.percentage=percent;
	 this.stuId=id;
 }
 
@Override
public String toString() {
	return "Student [name="+name+" age= "+age+" percentage=" + percentage + ", stuId=" + stuId + "]";
}

@Override
public void display()
{
	System.out.println("In Student");
	super.sayHai();
}
}
