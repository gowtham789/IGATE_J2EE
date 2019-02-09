package com.cg.ep.service;

import java.util.ArrayList;

import com.cg.ep.dto.ExecutiveDTO;
import com.cg.ep.exception.ExecutiveException;



public interface IExecutiveService 
{
	ExecutiveDTO viewById(String flight_no)throws ExecutiveException;
	boolean isFlightNo(String flight_no) throws ExecutiveException;
	ArrayList<ExecutiveDTO>viewAllFlights()throws ExecutiveException ;
}
