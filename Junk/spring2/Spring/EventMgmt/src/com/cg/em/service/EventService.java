package com.cg.em.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.em.beans.CustomerDTO;
import com.cg.em.beans.EventDTO;
import com.cg.em.dao.IEventDAO;
import com.cg.em.exception.EventException;

@Service("service") 
public class EventService implements IEventService{

	@Autowired
	IEventDAO edao;
	
	
	@Override
	public boolean addCustomer(CustomerDTO customer) throws EventException {
		// TODO Auto-generated method stub
		return edao.addCustomer(customer);
	}

	@Override
	public ArrayList<EventDTO> getEvents() throws EventException {
		// TODO Auto-generated method stub
		return edao.getEvents();
	}

	@Override
	public int bookEvent(EventDTO event, CustomerDTO customer)
			throws EventException {
		// TODO Auto-generated method stub
		return edao.bookEvent(event, customer);
	}

}
