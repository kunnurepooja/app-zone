package com.xworkz.appzone.dto.group;

import java.io.Serializable;

import org.apache.log4j.Logger;

public class GroupDTO implements Serializable {

	private static final Logger logger = Logger.getLogger(GroupDTO.class);

	private String groupName;

	public GroupDTO() {
		logger.info("created " + getClass().getSimpleName());

	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

}
