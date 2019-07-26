package com.xworkz.appzone.model.service.group;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.appzone.dto.group.GroupDTO;
import com.xworkz.appzone.entity.group.GroupEntity;
import com.xworkz.appzone.entity.login.LoginEntity;
import com.xworkz.appzone.exception.DAOException;
import com.xworkz.appzone.exception.ServiceException;
import com.xworkz.appzone.model.dao.group.GroupDAO;
import com.xworkz.appzone.model.dao.login.LoginDAO;
import com.xworkz.appzone.util.email.EmailSenderService;

@Service
public class GroupServiceImpl implements GroupService {

	private static final Logger logger = Logger.getLogger(GroupServiceImpl.class);

	@Autowired
	private GroupDAO createGroupDAO;

	@Autowired
	private LoginDAO loginDAO;

	@Autowired
	private EmailSenderService emailSendService;

	public GroupServiceImpl() {
		logger.info("created " + getClass().getSimpleName());
	}

	public Integer createGroup(GroupDTO group) throws ServiceException {
		logger.info("invoked createGroup method of service");
		try {
			GroupEntity groupEntity = new GroupEntity();
			BeanUtils.copyProperties(group, groupEntity);
			return createGroupDAO.saveGroup(groupEntity);
		} catch (DAOException e) {
			logger.error(e.getMessage(), e);
			throw new ServiceException(e.getMessage());
		}
	}

	public List<String> fetchAllGroupName() throws ServiceException {
		logger.info("inside fetchAll Geoup name");
		try {
			return createGroupDAO.fetchAllGroupName();
		} catch (DAOException e) {
			logger.error(e.getMessage(), e);
			throw new ServiceException(e.getMessage());
		}

	}

	public boolean validateEmailAndInviteUser(String groupName, String emailId) throws ServiceException {
		logger.info("inside fetchAll Group name");
		try {
			LoginEntity user = loginDAO.fetchByEmailId(emailId);
			if (user != null) {
				return emailSendService.inviteUser(user, groupName);
			}
			return false;
		} catch (DAOException e) {
			logger.error(e.getMessage());
			throw new ServiceException(e.getMessage());
		}
	}

}
