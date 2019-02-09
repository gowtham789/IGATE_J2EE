package com.igate.service;

import java.util.ArrayList;

import com.igate.dao.EventDAO;
import com.igate.dao.IEventDAO;
import com.igate.dto.Events;
import com.igate.dto.users;
import com.igate.exception.EventException;

public class EventService implements IEventService {
		
	IEventDAO edao=new EventDAO();
	
	@Override
	public ArrayList<Events> geteventType() throws EventException {
		// TODO Auto-generated method stub
		return edao.geteventType();
	}

	@Override
	public void Adduser(users u) throws EventException {
		  edao.Adduser(u);
		
	}

	
	@Override
	public Events byid(int id) throws EventException {
		// TODO Auto-generated method stub
		return edao.byid(id);
	}

	@Override
	public int booking(Events e, users u) throws EventException {
		// TODO Auto-generated method stub
		return edao.booking(e, u);
	}
	
	
}
