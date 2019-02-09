package com.cg.bid.dao;

import java.util.ArrayList;
import java.util.List;

import com.cg.bid.dto.BiddingDto;

public interface IBiddingDao {

	boolean isLogin(String username,String Password);
	public ArrayList<BiddingDto> getItems();
	public BiddingDto viewById(int itemid);
	boolean updateStatus(int id);

}
