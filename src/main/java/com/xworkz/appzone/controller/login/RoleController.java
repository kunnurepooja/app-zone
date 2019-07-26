package com.xworkz.appzone.controller.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.xworkz.appzone.exception.ServiceException;
import com.xworkz.appzone.model.service.group.GroupService;
import com.xworkz.appzone.model.service.role.RoleService;

@Controller
@RequestMapping("/")
public class RoleController {

	public static final Logger logger = Logger.getLogger(RoleController.class);

	@Autowired
	private RoleService roleService;

	@Autowired
	private GroupService groupService;

	public RoleController() {
		logger.info("created " + getClass().getSimpleName());
	}

	@GetMapping("getRole")
	public ModelAndView fetchRoleNamesAndGroups() {
		logger.info("invoked fetchRoleNamesAndGroups method ");
		ModelAndView view = new ModelAndView();
		try {
			view.addObject("roles", roleService.fetchRole());
			view.addObject("userNames", roleService.fetchUserNames());
			view.addObject("groups", groupService.fetchAllGroupName());
			view.setViewName("managerole");
			return view;
		} catch (ServiceException e) {
			logger.error(e.getMessage());
		}
		return null;
	}

	@PostMapping("manageRole")
	public ModelAndView manageRole(String groupName, String userName, String role,HttpServletRequest request) {
		logger.info("invoked manageRole method ");
		ModelAndView view = new ModelAndView("managerole");
		HttpSession session = request.getSession(false);
		if (session==null || session.getAttribute("user") == null) {
			view.setViewName("index");
			return view;
		}
		try {
			int noOfRowsUpdate = roleService.manageRole(userName, role);
			if (noOfRowsUpdate > 0) {
				view.addObject("upadateRow", "role has been update");
			} else {
				view.addObject("upadateRow", "role has been update");
			}
			return view;
		} catch (ServiceException e) {
			logger.error(e.getMessage());
		}
		return null;

	}

}
