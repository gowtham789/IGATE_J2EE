package com.cg.event.dao;

import java.util.ArrayList;

import com.cg.event.dto.EventsDTO;
import com.cg.event.dto.UsersDTO;
import com.cg.event.exception.EventException;

public interface IEventDAO 
{

	ArrayList<EventsDTO> getEventType() throws EventException;
	void addUser(UsersDTO u) throws EventException;
	EventsDTO getById(int id) throws EventException;
	int getBooking(EventsDTO e,UsersDTO u) throws EventException;
}
