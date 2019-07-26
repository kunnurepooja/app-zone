package com.xworkz.appzone.model.dao.login;

import java.util.List;

import com.xworkz.appzone.dto.login.LoginDTO;
import com.xworkz.appzone.entity.login.LoginEntity;
import com.xworkz.appzone.exception.DAOException;

public interface LoginDAO {
	
	
	public LoginEntity getByUserName(LoginDTO user) throws DAOException ;
	
	public LoginEntity fetchByEmailId(String Email) throws DAOException;
	
	public List<String> fetchUserNames() throws DAOException;
	
	public List<String> fetchRole() throws DAOException;
	
	public int updateRoleByUserName(String userName,String role) throws DAOException;
}
