package com.igate;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class HelloMain {

	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("anno.xml");
		
		//Ask the factory to inject a bean with id myAccount
		Account a1=(Account) factory.getBean("savingsAcc");
		a1.calculateInterest();
			

	}

}
