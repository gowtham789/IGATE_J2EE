package com.cg;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;


public class EmployeeMain 
{

	public static void main(String[] args) 
	{
		ApplicationContext appContext = new ClassPathXmlApplicationContext("empConfig.xml");
		SBU e=(SBU)appContext.getBean("sbu");
		System.out.println("SbuId  	 :"+e.getSbuId());
		System.out.println("SbuName  :"+e.getSbuName());
		System.out.println("SbuHead  :"+e.getSbuHead());
		System.out.println("****Employee Details****");
		System.out.println(e.getEmpList());
	}
	
	}
