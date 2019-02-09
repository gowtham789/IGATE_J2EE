package com.igate;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class HelloMain {

	public static void main(String[] args) {
		Resource res = new ClassPathResource("helloConfig.xml");
		BeanFactory factory = new XmlBeanFactory(res);
		
		//Ask the factory to inject a bean with id myAccount
		Account a1=(Account) factory.getBean("myAccount");
		a1.calculateInterest();
			

	}

}
