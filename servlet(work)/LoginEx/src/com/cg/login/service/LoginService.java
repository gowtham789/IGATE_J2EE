package com.cg.login.service;

import com.cg.login.dao.LoginDao;
import com.cg.login.exception.LoginException;

public class LoginService implements ILoginService {
	LoginDao ldao=new LoginDao();
	@Override
	public boolean isLogin(String username, String Password)
			throws LoginException {
		return ldao.isLogin(username, Password);
	}

	

}
