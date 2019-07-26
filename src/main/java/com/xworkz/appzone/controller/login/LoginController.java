package com.xworkz.appzone.controller.login;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.xworkz.appzone.dto.login.LoginDTO;
import com.xworkz.appzone.entity.login.LoginEntity;
import com.xworkz.appzone.exception.ControllerException;
import com.xworkz.appzone.exception.ServiceException;
import com.xworkz.appzone.model.service.login.LoginService;

@Controller
@RequestMapping("/")
public class LoginController {

	@Autowired
	private LoginService loginService;

	private static final Logger logger = Logger.getLogger(LoginController.class);

	public LoginController() {
		logger.info("created " + getClass().getSimpleName());
	}

	@PostMapping("login")
	public ModelAndView validateUser(LoginDTO user,HttpServletRequest request) throws ControllerException {
		logger.info("inside validateUser method");
		try {
			LoginEntity userDetails = loginService.validateUser(user);
			return validateWithData(userDetails,request);
		} catch (ServiceException e) {
			logger.error(e.getMessage());
			throw new ControllerException(e.getMessage());
		}
	}

	public ModelAndView validateWithData(LoginEntity user,HttpServletRequest request) {
		ModelAndView view = new ModelAndView();
		if (user == null) {
			view.addObject("credentials", "Your userName or password is invalid");
			view.setViewName("/index");
			return view;
		} else {
			HttpSession session= request.getSession();
			logger.info("inside validateUser method");
			session.setAttribute("user",user.getUserName());
			view.setViewName(getViewBasedOnRole(user));
			return view;
		}
	}

	private String getViewBasedOnRole(LoginEntity user) {
		if (user.getRole().equals("owner")) {
			return "/Group";
		}
		return "/SeachApp";
	}

}
