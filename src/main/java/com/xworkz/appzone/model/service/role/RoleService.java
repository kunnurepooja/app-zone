package com.xworkz.appzone.model.service.role;

import java.util.List;

import com.xworkz.appzone.exception.ServiceException;

public interface RoleService {

	public List<String> fetchUserNames() throws ServiceException;

	public List<String> fetchRole() throws ServiceException;

	public int manageRole(String userName, String role) throws ServiceException;;

}
