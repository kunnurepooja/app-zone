package com.xworkz.appzone.dto.login;

import org.apache.log4j.Logger;

public class LoginDTO {

	private static final Logger logger = Logger.getLogger(LoginDTO.class);
	private String userName;
	private String password;

	public LoginDTO() {
		logger.info("created " + getClass().getSimpleName());
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "LoginDTO [userName=" + userName + ", password=" + password + "]";
	}

}
