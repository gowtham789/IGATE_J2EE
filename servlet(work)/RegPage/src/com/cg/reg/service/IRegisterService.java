package com.cg.reg.service;

import com.cg.reg.dto.RegisterDto;
import com.cg.reg.exception.RegisterException;

public interface IRegisterService {
	
	int insertRegister(RegisterDto rdto) throws RegisterException;

}
