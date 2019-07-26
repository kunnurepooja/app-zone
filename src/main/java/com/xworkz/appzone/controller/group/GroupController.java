package com.xworkz.appzone.controller.group;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.xworkz.appzone.dto.group.GroupDTO;
import com.xworkz.appzone.exception.ServiceException;
import com.xworkz.appzone.model.service.group.GroupService;

@Controller
@RequestMapping("/")
public class GroupController {

	private static final Logger logger = Logger.getLogger(GroupController.class);

	@Autowired
	private GroupService createGroupService;

	@SuppressWarnings("null")
	@PostMapping("createGroup")
	public ModelAndView createGroup(GroupDTO group, HttpServletRequest request) {
		logger.info("inside create group method of Controller");
		ModelAndView view = new ModelAndView("CreateGroup");
		HttpSession session = request.getSession(false);
		
		if (session==null || session.getAttribute("user") == null) {
			view.setViewName("index");
			return view;
		} try {
			createGroupService.createGroup(group);
			view.addObject("successOrFailure", "your group is created successfull");
			return view;
		} catch (ServiceException e) {
			logger.error(e.getMessage(), e);
			view.addObject("successOrFailure", "fails to create group");
			return view;
		}
	}

	@GetMapping("getGroupName")
	public ModelAndView getGroupName(HttpServletRequest request) {
		logger.info("inside getGroupName of Controller");
		ModelAndView view = new ModelAndView("managegroup");
		List<String> list;
		HttpSession session = request.getSession(false);
		if (session==null || session.getAttribute("user") == null) {
			view.setViewName("index");
			return view;
		} 
		try {
			list = createGroupService.fetchAllGroupName();
			view.addObject("groupName", list);
			return view;
		} catch (ServiceException e) {
			logger.error(e.getMessage(), e);
		}
		return null;
	}

	@SuppressWarnings("null")
	@PostMapping("manageGroup")
	public ModelAndView manageGroup(@RequestParam String groupName, @RequestParam String emailId,HttpServletRequest request) {
		logger.info("inside manage group");
		HttpSession session = request.getSession(false);
		ModelAndView view = new ModelAndView("managegroup");
		if (session==null || session.getAttribute("user") == null) {
			view.setViewName("index");
			return view;
		} 
		try {
			boolean result = createGroupService.validateEmailAndInviteUser(groupName, emailId);
			if (result) {
				view.addObject("sendMessage", "Invitaion is done SuccessFully");
			} else {
				view.addObject("sendMessage", "InValideMailId");
			}
			return view;
		} catch (ServiceException e) {
			logger.error(e.getMessage(), e);
		}
		return null;
	}

}
