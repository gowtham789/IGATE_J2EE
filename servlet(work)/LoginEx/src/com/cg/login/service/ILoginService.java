package com.cg.login.service;

import com.cg.login.exception.LoginException;

public interface ILoginService {

	boolean isLogin(String username,String Password) throws LoginException;
}
