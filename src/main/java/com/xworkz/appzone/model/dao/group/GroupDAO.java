package com.xworkz.appzone.model.dao.group;

import java.util.List;

import com.xworkz.appzone.entity.group.GroupEntity;
import com.xworkz.appzone.entity.login.LoginEntity;
import com.xworkz.appzone.exception.DAOException;

public interface GroupDAO {
	
	public Integer saveGroup(GroupEntity group) throws DAOException;

	public List<String> fetchAllGroupName() throws DAOException;;
	
	

}
