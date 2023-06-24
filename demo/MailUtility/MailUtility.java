package com.example.demo.MailUtility;

import java.util.logging.LogManager;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class MailUtility {
	


	@Autowired
	JavaMailSender emailSender;

	
	public void sendSimpleMessage(String to, String mailSubject, String body) {
		
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(to);
		message.setSubject(mailSubject);
		message.setText(body);
		emailSender.send(message);
	}

}
