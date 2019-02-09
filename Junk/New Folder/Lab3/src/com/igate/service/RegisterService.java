package com.igate.service;

import com.igate.dao.RegisterDao;
import com.igate.dto.RegisterDto;

public class RegisterService implements IRegisterService{

	RegisterDao rdao=new RegisterDao();

	@Override
	public String insertRegister(RegisterDto r) {
		
		return rdao.insertRegister(r);
	}
	
	
	
}
