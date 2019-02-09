package com.igate.lesson22;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class EmployeeUnMarshallerDemo {

	public static void main(String[] args) {
		Employee employee;

		// create an instance of JAXBContext
		JAXBContext context;
		try {
			context = JAXBContext.newInstance(Employee.class);

			// create an instance of unmarshaller from JAXBContext
			Unmarshaller unmarshaller = context.createUnmarshaller();
			// create source stream from where unmarshaller will read xml
			// contents
			File file = new File("resources/emp.xml");
			// unmarshall the XML file into and object
			employee = (Employee) unmarshaller.unmarshal(file);
			System.out.println("Unmarshalling completed..");
			System.out.println("Employee Details:");
			System.out.println("ID:" + employee.getId());
			System.out.println("Name:" + employee.getName());
			System.out.println("JoinDate:" + employee.getJoinDate());
			System.out.println("Role:" + employee.getRole());
			System.out.println("Level:" + employee.getLevel());
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
