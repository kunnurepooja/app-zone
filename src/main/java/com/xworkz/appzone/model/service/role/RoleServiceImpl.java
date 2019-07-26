package com.xworkz.appzone.model.service.role;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.appzone.exception.DAOException;
import com.xworkz.appzone.exception.ServiceException;
import com.xworkz.appzone.model.dao.login.LoginDAO;

@Service
public class RoleServiceImpl implements RoleService {

	private static final Logger logger = Logger.getLogger(RoleServiceImpl.class);
	@Autowired
	private LoginDAO loginDAO;

	public RoleServiceImpl() {
		logger.info("created " + getClass().getSimpleName());

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

	public int manageRole(String userName, String role) throws ServiceException {
		logger.info("inside fetchRole...");
		try {
			return loginDAO.updateRoleByUserName(userName, role);
		} catch (DAOException e) {
			logger.info(e.getMessage());
			throw new ServiceException(e.getMessage());
		}
	}

}
