package com.igate.lesson22;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class EmployeeMarshallerDemo {

	public static void main(String[] args) {
		//create an object to serialize as XML
		Employee employee = new Employee();
		employee.setId(101);
		employee.setName("Rajat Sharma");
		employee.setJoinDate("15/04/2004");
		employee.setLevel(8);
		employee.setRole("Manager");

		try {
			// create an instance of JAXBContext
			JAXBContext context = JAXBContext.newInstance(Employee.class);
			//create an instance of marshaller from JAXBContext
			Marshaller marshaller = context.createMarshaller();
			//create destination stream where marshaller will write xml contents
			FileWriter writer = new FileWriter(new File("resources/emp.xml"));
			//marshall the object into an XML file
			marshaller.marshal(employee, writer);
			System.out.println("Marshalling completed..");
		} catch (JAXBException | IOException e) {
			e.printStackTrace();
		}

	}
}
