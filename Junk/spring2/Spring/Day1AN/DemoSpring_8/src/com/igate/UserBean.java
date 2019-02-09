package com.igate;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("u")
public class UserBean {
	@Value("${userid}")
	// @Value("199")
	private int userId;
	
	@Value("${uname}")
	// @Value("majrul")
	private String username;

	@Value("${password}")
	// @Value("majrul123")
	private String password;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
