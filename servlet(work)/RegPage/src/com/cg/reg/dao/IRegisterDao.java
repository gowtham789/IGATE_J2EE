package com.cg.reg.dao;

import com.cg.reg.dto.RegisterDto;
import com.cg.reg.exception.RegisterException;

public interface IRegisterDao {
	
	int insertRegister(RegisterDto rdto) throws RegisterException;
}
