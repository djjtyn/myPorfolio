//This class allows email's to be sent to the email address stored in the application environment
package com.porfolio.emailService;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSender {
	
	public void sendEmail(String recipentEmailAddress, String body, String subject, JavaMailSender mailSender) {
		SimpleMailMessage emailDetails = new SimpleMailMessage();
		emailDetails.setTo(recipentEmailAddress);
		emailDetails.setText(body);
		emailDetails.setSubject(subject);
		mailSender.send(emailDetails);
	}
}
