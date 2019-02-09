package com.igate.lesson22;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class MarshallObjectDemo {

	public static void main(String[] args) {
		try {
			JAXBContext context = JAXBContext.newInstance(Location.class);

			Location location = new Location();
			location.setCity("Pune");
			location.setCapacity(5000);
			location.setState("Maharashtra");
			
			
			File file = new File("resources/pune.xml");
			Marshaller marshaller = context.createMarshaller();
			marshaller.marshal(location, file);
			System.out.println("Operation done...");
		} catch (JAXBException e) {
			
		}
		
	}
}
