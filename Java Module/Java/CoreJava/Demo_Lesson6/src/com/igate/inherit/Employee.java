package com.igate.inherit;

public class Employee extends Person{
	float sal;
	String desig;
	
	public Employee(String name, int age,float sal, String desig) {
		super(name, age);
		this.sal = sal;
		this.desig = desig;
	}
	public Employee() {
		super();
		this.sal = 15000f;
		this.desig = "SE";
	}
	@Override
	public String toString() {
		return "Employee [name="+name+" age= "+age+" sal=" + sal + ", desig=" + desig + "]";
	}
	public void display()
	{
		System.out.println("In employee");
	}

}
