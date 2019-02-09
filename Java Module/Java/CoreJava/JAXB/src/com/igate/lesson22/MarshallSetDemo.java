package com.igate.lesson22;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class MarshallSetDemo {

	public static void main(String[] args) {
		
		try {
			JAXBContext context = JAXBContext.newInstance(Locations.class);
			//define data
			Set<Location> locations = new HashSet<>();
			locations.add(new Location("Pune", 5000, "MAH"));
			locations.add(new Location("Mumbai", 5600, "MAH"));
			locations.add(new Location("Noida", 3000, "UP"));
			locations.add(new Location("Hyderabad", 2000, "AP"));
			locations.add(new Location("Banglore", 5000, "KA"));
			locations.add(new Location("Chennai", 3000, "TN"));
			locations.add(new Location("Gandhinagar", 1000, "GUJ"));
			
			Locations locs = new Locations();
			locs.setLocations(locations);
			
			File file = new File("resources/offices.xml");
			
			Marshaller marshaller = context.createMarshaller();
			marshaller.marshal(locs, file);
			
			System.out.println("done...");
			
			
			
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
