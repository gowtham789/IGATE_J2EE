package com.cg.em.dao;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.cg.em.beans.CustomerDTO;
import com.cg.em.beans.EventDTO;
import com.cg.em.exception.EventException;
import com.cg.em.mapper.EventMapper;


@Repository("edao")
public class EventDAO extends JdbcDaoSupport implements IEventDAO{

	@Autowired
	private DataSource dataSource;
	
	@PostConstruct
	private void initialize() {
	setDataSource(dataSource);
	}

	
	@Override
	public boolean addCustomer(CustomerDTO customer) throws EventException {
		
		
		String sql="INSERT INTO event_user VALUES(?,?,?)";   
		Object[] params=new Object[]{customer.getName(),customer.getEventType(),customer.getSeats()};
		int status=getJdbcTemplate().update(sql, params);
		boolean flag=false;
		if(status>0)
			flag=true;
		return flag;
			
		}

	@Override
	public ArrayList<EventDTO> getEvents() throws EventException {
		
			String sql = "SELECT * FROM events";
			List<EventDTO> cList = (List<EventDTO>)getJdbcTemplate().query(sql,new EventMapper());
		   return  (ArrayList<EventDTO>) cList;
		}

	@Override
	public int bookEvent(EventDTO event, CustomerDTO customer)
			throws EventException {
			System.out.println(event+""+customer);
		String sql="INSERT INTO eventbooking VALUES(booking.nextval,?,?,?)";   
		Object[] params=new Object[]{event.getEventId(),customer.getName(),customer.getSeats()};
		return getJdbcTemplate().update(sql, params);
		}

}
