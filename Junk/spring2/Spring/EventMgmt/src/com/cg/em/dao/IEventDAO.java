package com.cg.em.dao;

import java.util.ArrayList;

import com.cg.em.beans.CustomerDTO;
import com.cg.em.beans.EventDTO;
import com.cg.em.exception.EventException;

public interface IEventDAO {

	public boolean addCustomer(CustomerDTO customer) throws EventException;
	public ArrayList<EventDTO> getEvents() throws EventException;
	public int bookEvent(EventDTO event,CustomerDTO customer) throws EventException; 
}
