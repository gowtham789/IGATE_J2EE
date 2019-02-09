package com.cg.bid.service;

import java.util.ArrayList;
import java.util.List;

import com.cg.bid.dao.BiddingDao;
import com.cg.bid.dto.BiddingDto;

public class BiddingService implements IBiddingService{

	BiddingDao bdao=new BiddingDao();
	@Override
	public boolean isLogin(String username, String Password) {
		// TODO Auto-generated method stub
		return bdao.isLogin(username, Password);
	}
	@Override
	public ArrayList<BiddingDto> getItems() {
		return bdao.getItems();
	}
	@Override
	public BiddingDto viewById(int itemid) {
		return bdao.viewById(itemid);
	}
	@Override
	public boolean updateStatus(int id) {
		return bdao.updateStatus(id);
	}
	

	
}
