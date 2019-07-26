package com.xworkz.appzone.model.service.group;

import java.util.List;

import com.xworkz.appzone.dto.group.GroupDTO;
import com.xworkz.appzone.exception.ServiceException;

public interface GroupService {

	public Integer createGroup(GroupDTO group) throws ServiceException;

	public List<String> fetchAllGroupName() throws ServiceException;

	public boolean validateEmailAndInviteUser(String groupName, String emailId) throws ServiceException;;
}
