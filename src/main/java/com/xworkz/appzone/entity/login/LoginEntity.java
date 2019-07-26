package com.xworkz.appzone.entity.login;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.log4j.Logger;

import com.xworkz.appzone.dto.login.LoginDTO;


@Entity
@Table(name="login")
public class LoginEntity {
	
	private static final Logger logger = Logger.getLogger(LoginDTO.class);
	@Id
	@Column(name="username")
	private String userName;
	@Column(name="password")
	private String password;
	@Column(name="emailId")
	private String emailId;
	@Column(name="role")
	private String role;
	@Column(name="isActive")
	private boolean isActive;

	public LoginEntity() {
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

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	

	@Override
	public String toString() {
		return "LoginDTO [userName=" + userName + ", password=" + password + ", emailId=" + emailId + ", role=" + role
				+ ", isActive=" + isActive + "]";
	}

}
