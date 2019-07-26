package com.xworkz.appzone.entity.group;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.log4j.Logger;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="grouptable")
public class GroupEntity implements Serializable {

	private static final Logger logger = Logger.getLogger(GroupEntity.class);

	@Id
	@GenericGenerator(name = "auto", strategy = "increment")
	@GeneratedValue(generator = "auto")
	@Column(name = "groupId")
	private int groupId;
	@Column(name = "groupName")
	private String groupName;

	public GroupEntity() {

		logger.info("created " + getClass().getSimpleName());
	}

	public int getGroupId() {
		return groupId;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

}
