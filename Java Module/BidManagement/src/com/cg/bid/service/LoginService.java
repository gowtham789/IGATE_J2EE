package com.cg.bid.service;

import java.util.ArrayList;

import com.cg.bid.dao.Logindao;
import com.cg.bid.dto.BidDTO;

public class LoginService implements ILogin{

	
	Logindao ldao=new Logindao();
	
	@Override
	public boolean isValid(String username, String password) {
		
		return ldao.isValid(username, password);
	}

	@Override
	public ArrayList<BidDTO> getAllBid() {
		
		return  ldao.getAllBid() ;
	}

	@Override
	public BidDTO getBidbyItemid(int id) {
		
		return ldao.getBidbyItemid(id);
	}

	@Override
	public boolean updateStatus(int id) {
	
		return ldao.updateStatus(id);
	}


}
