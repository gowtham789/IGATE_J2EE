package com.cg;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;



public class EmployeeMain 
{

	public static void main(String[] args) 
	{
		Resource res = new ClassPathResource("empConfig.xml");
		BeanFactory factory = new XmlBeanFactory(res);
		Employee e1=(Employee)factory.getBean("myEmp");
		e1.show();
	}

}
