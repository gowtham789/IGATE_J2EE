package com.igate.treedemos;

public class Employee implements Comparable{
	int empId;
	String name;
	float sal;


	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getSal() {
		return sal;
	}

	public void setSal(float sal) {
		this.sal = sal;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(int empId, String name, float sal) {
		super();
		this.empId = empId;
		this.name = name;
		this.sal = sal;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", sal=" + sal
				+ "]";
	}

	@Override
	public int compareTo(Object o) {
		Employee temp=(Employee)o;
		/*if(this.sal>temp.sal)
			return 1;
		else if(this.sal<temp.sal)
			return -1;
		else
		return 0;*/
		
		/*if(this.empId>temp.empId)
			return 1;
		else if(this.empId<temp.empId)
			return -1;
		else
		return 0;*/
		
		return (this.name).compareTo(temp.name);
	}

}
