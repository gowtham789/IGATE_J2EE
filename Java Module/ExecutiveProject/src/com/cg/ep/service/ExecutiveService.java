package com.cg.ep.service;


import java.util.ArrayList;

import com.cg.ep.dao.ExecutiveDAO;
import com.cg.ep.dto.ExecutiveDTO;
import com.cg.ep.exception.ExecutiveException;

public class ExecutiveService implements IExecutiveService
{
	
	ExecutiveDAO ex =new ExecutiveDAO();

	@Override
	public ExecutiveDTO viewById(String flight_no) throws ExecutiveException {
		
		return ex.viewById(flight_no);
	}

	@Override
	public boolean isFlightNo(String flight_no) throws ExecutiveException {
		
		return ex.isFlightNo(flight_no);
	}

	@Override
	public ArrayList<ExecutiveDTO> viewAllFlights() throws ExecutiveException {
		
		return ex.viewAllFlights();
	}

	public boolean isDeptime(String dtime) throws ExecutiveException {
		
		return ex.isDeptime(dtime);
	}

	public ExecutiveDTO viewByDtime(String dtime) throws ExecutiveException {
		// TODO Auto-generated method stub
		return ex.viewByDtime(dtime);
	}

	public boolean isArrtime(String atime) throws ExecutiveException {
		// TODO Auto-generated method stub
		return ex.isArrtime(atime);
	}

	public ExecutiveDTO viewByAtime(String atime) throws ExecutiveException{
		// TODO Auto-generated method stub
		return ex.viewByAtime(atime);
	}

	public boolean isDepcity(String dcity) throws ExecutiveException {
		// TODO Auto-generated method stub
		return ex.isDepcity(dcity);
	}

	public ExecutiveDTO viewDepcity(String dcity) throws ExecutiveException {
		// TODO Auto-generated method stub
		return ex.viewDepcity(dcity);
	}

	
	
	
	
	

}
