package com.vaccine.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

@Component
public class MailService {

	JavaMailSenderImpl javaMailSenderImpl;
	
	@Autowired
	public MailService(JavaMailSenderImpl javaMailSenderImpl) {
		super();
		System.out.println("Invoked the JavaMailSender object");
		System.out.println();

		this.javaMailSenderImpl = javaMailSenderImpl;
	}
	
	public boolean sendMail(String to , String subject , String body) {
		System.out.println("Inside the sendMail method in the MailService class");
		System.out.println();

		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		
		boolean isMailSended = false;
		try {
			simpleMailMessage.setTo(to);
			simpleMailMessage.setSubject(subject);
			simpleMailMessage.setText(body);
			javaMailSenderImpl.send(simpleMailMessage);
			isMailSended=true;
		} catch (MailException e) {
			e.printStackTrace();
		}
		return isMailSended;
		
	}
	
	
	
}
