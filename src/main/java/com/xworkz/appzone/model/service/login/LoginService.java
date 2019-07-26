package com.xworkz.appzone.model.service.login;

import java.util.List;

import org.springframework.ui.Model;

import com.xworkz.appzone.dto.login.LoginDTO;
import com.xworkz.appzone.entity.login.LoginEntity;
import com.xworkz.appzone.exception.DAOException;
import com.xworkz.appzone.exception.ServiceException;

public interface LoginService {

	public LoginEntity validateUser(LoginDTO user) throws ServiceException;

}
