package com.cg.reg.service;

import com.cg.reg.dao.RegisterDao;
import com.cg.reg.dto.RegisterDto;
import com.cg.reg.exception.RegisterException;

public class RegisterService implements IRegisterService{

	RegisterDao rdao= new RegisterDao();
	@Override
	public int insertRegister(RegisterDto rdto) throws RegisterException {
		return rdao.insertRegister(rdto);
	}

	
	

}
