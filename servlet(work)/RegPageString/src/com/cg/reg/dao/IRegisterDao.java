package com.cg.reg.dao;

import com.cg.reg.dto.RegisterDto;
import com.cg.reg.exception.RegisterException;

public interface IRegisterDao {
	
	String insertRegister(RegisterDto rdto) throws RegisterException;
}
