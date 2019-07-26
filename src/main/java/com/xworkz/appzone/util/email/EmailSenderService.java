package com.xworkz.appzone.util.email;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import com.xworkz.appzone.entity.login.LoginEntity;

@Service
public class EmailSenderService {

	private static final Logger logger = Logger.getLogger(EmailSenderService.class);

	@Autowired
	private MailSender mailSender;

	public EmailSenderService() {
		logger.info(" created " + getClass().getSimpleName());
	}

	public boolean inviteUser(LoginEntity user, String groupName) {
		SimpleMailMessage mailData = new SimpleMailMessage();
		mailData.setTo(user.getEmailId());
		mailData.setSubject("Welcome to AppZone Of Xworkz");
		String body = "Hi " + user.getUserName() + "Welcome to AppZone Of Xworkz\n you have added to the " + groupName;
		mailData.setText(body);
		try {
			mailSender.send(mailData);
			return true;
		} catch (MailException e) {
			logger.error(e.getMessage());
		}
		return false;
	}

}
