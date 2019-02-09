package com.igate.dao;

import java.util.ArrayList;

import com.igate.dto.Events;
import com.igate.dto.users;
import com.igate.exception.EventException;

public interface IEventDAO {

	ArrayList<Events> geteventType() throws EventException;
	void Adduser(users u) throws EventException;
	Events byid(int id) throws EventException;
	int booking(Events e,users u) throws EventException;
	
}
