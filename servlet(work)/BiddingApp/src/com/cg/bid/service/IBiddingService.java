package com.cg.bid.service;

import java.util.ArrayList;
import java.util.List;

import com.cg.bid.dto.BiddingDto;

public interface IBiddingService {

	boolean isLogin(String username,String Password);
	public ArrayList<BiddingDto> getItems();
	public BiddingDto viewById(int itemid);
	boolean updateStatus(int id);
}
