package com.cg.em.service;

import java.util.ArrayList;

import com.cg.em.beans.CustomerDTO;
import com.cg.em.beans.EventDTO;
import com.cg.em.exception.EventException;

public interface IEventService {

	public boolean addCustomer(CustomerDTO customer) throws EventException;
	public ArrayList<EventDTO> getEvents() throws EventException;
	public int bookEvent(EventDTO event,CustomerDTO customer) throws EventException;
}
