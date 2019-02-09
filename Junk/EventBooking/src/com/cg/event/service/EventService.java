package com.cg.event.service;

import java.util.ArrayList;

import com.cg.event.dao.EventDAO;
import com.cg.event.dao.IEventDAO;
import com.cg.event.dto.EventsDTO;
import com.cg.event.dto.UsersDTO;
import com.cg.event.exception.EventException;

public class EventService implements IEventService
{
	IEventDAO es=new EventDAO();
	@Override
	public ArrayList<EventsDTO> getEventType() throws EventException {
	
		return es.getEventType();
	}

	@Override
	public void addUser(UsersDTO u) throws EventException 
	{
		es.addUser(u);
		
	}

	@Override
	public EventsDTO getById(int id) throws EventException {
		
		return es.getById(id);
	}

	@Override
	public int getBooking(EventsDTO e, UsersDTO u) throws EventException {
		
		return es.getBooking(e, u);
	}
	

}
