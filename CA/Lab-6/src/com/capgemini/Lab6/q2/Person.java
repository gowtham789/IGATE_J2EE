package com.capgemini.Lab6.q2;

public class Person {
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	private String name;
	private float age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getAge() {
		return age;
	}
	public void setAge(float age) {
		this.age = age;
	}
}
