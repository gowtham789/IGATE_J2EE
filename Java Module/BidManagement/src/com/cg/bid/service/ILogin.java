package com.cg.bid.service;

import java.util.ArrayList;

import com.cg.bid.dto.BidDTO;

public interface ILogin {

	//method to validate login
	
		boolean isValid(String username,String password);
		
		//getting all the details from bid table
		
		ArrayList<BidDTO> getAllBid();
		
		//getting all the details from bid table by bid item
		
		BidDTO getBidbyItemid(int id);
		
		//to update in items status
		boolean updateStatus(int id);
}
