package com.cg;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmployeeMain 
{

	public static void main(String[] args) 
	{
		ApplicationContext factory = new ClassPathXmlApplicationContext("empAnno.xml");
		Employee a1=(Employee) factory.getBean("Emp");
		a1.show();
	}

}
