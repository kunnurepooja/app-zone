package com.xworkz.appzone.model.service.login;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.xworkz.appzone.dto.login.LoginDTO;
import com.xworkz.appzone.entity.login.LoginEntity;
import com.xworkz.appzone.exception.DAOException;
import com.xworkz.appzone.exception.ServiceException;
import com.xworkz.appzone.model.dao.login.LoginDAO;

@Service
public class LoginServiceImpl implements LoginService {

	private static final Logger logger = Logger.getLogger(LoginServiceImpl.class);

	@Autowired
	private LoginDAO loginDAO;

	public LoginServiceImpl() {
		logger.info("created " + getClass().getSimpleName());
	}

	public LoginEntity validateUser(LoginDTO user) throws ServiceException {
		logger.info("inside validate User method in service");
		try {
			return loginDAO.getByUserName(user);
		} catch (DAOException e) {
			logger.error(e.getMessage());
			throw new ServiceException(e.getMessage());
		}

	}

	public List<String> fetchUserNames() throws ServiceException {
		logger.info("inside fetchRole...");
		try {
			return loginDAO.fetchUserNames();
		} catch (DAOException e) {
			logger.info(e.getMessage());
			throw new ServiceException(e.getMessage());
		}
	}

	public List<String> fetchRole() throws ServiceException {
		logger.info("inside fetchRole...");
		try {
			return loginDAO.fetchRole();
		} catch (DAOException e) {
			logger.info(e.getMessage());
			throw new ServiceException(e.getMessage());
		}
	}

}
