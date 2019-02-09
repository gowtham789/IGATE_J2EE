package com.cg.lab7.dto;

public class Employee implements Comparable<Integer>{

		protected int empId;
		protected String empName;
		protected float salary;
		protected String desig;
		protected String insuranceScheme;
		
		public Employee() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Employee(int empId, String empName, float salary, String desig,
				String insuranceScheme) {
			super();
			this.empId = empId;
			this.empName = empName;
			this.salary = salary;
			this.desig = desig;
			this.insuranceScheme = insuranceScheme;
		}

		public int getEmpId() {
			return empId;
		}

		public void setEmpId(int empId) {
			this.empId = empId;
		}

		public String getEmpName() {
			return empName;
		}

		public void setEmpName(String empName) {
			this.empName = empName;
		}

		public float getSalary() {
			return salary;
		}

		public void setSalary(float salary) {
			this.salary = salary;
		}

		public String getDesig() {
			return desig;
		}

		public void setDesig(String desig) {
			this.desig = desig;
		}

		public String getInsuranceScheme() {
			return insuranceScheme;
		}

		public void setInsuranceScheme(String insuranceScheme) {
			this.insuranceScheme = insuranceScheme;
		}

		@Override
		public String toString() {
			return "Employee [empId=" + empId + ", empName=" + empName
					+ ", salary=" + salary + ", desig=" + desig
					+ ", insuranceScheme=" + insuranceScheme + "]";
		}

		@Override
		public int compareTo(Integer i) {
			
			if(this.getEmpId()>i)
				return 1;
			else if(this.getEmpId()<0)
				return -1;
			else 
				return 0;
		}
		
		
	}


