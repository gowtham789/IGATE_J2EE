package com.igate.inherit;

public class Person {
 String name;
 @Override
public String toString() {
	return "Person [name=" + name + ", age=" + age + "]";
}
int age;
public Person() {
	super();
	this.name="Kumar";
	this.age=45;
}
public Person(String name, int age) {
	super();
	this.name = name;
	this.age = age;
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

public void display()
{
	System.out.println("In person");
}

public void sayHai()
{
	System.out.println("You should use super to call me!!!!");
}
}
