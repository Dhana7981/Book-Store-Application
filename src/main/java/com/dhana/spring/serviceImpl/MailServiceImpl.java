package com.dhana.spring.serviceImpl;

import java.io.File;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.dhana.spring.service.MailService;

@Service
public class MailServiceImpl implements MailService{
	
	@Autowired
	JavaMailSender mailSender;
	
	@Override
	public void sendMail(String from, String to, String subject, String body) {
		try {
			MimeMessage mimeMessage = mailSender.createMimeMessage();
			MimeMessageHelper mailMsg = new MimeMessageHelper(mimeMessage);
			mailMsg.setFrom(from);
			mailMsg.setTo(to);
			mailMsg.setSubject(subject);
			mailMsg.setText(body, true);
			mailSender.send(mimeMessage);
			} catch (Exception ex) {
			ex.printStackTrace();
			}
		
	}

	@Override
	public void sendMail(String from, String to, String subject, String body, File file) {
			try {
				MimeMessage mimeMessage = mailSender.createMimeMessage();
				MimeMessageHelper mailMsg = new MimeMessageHelper(mimeMessage, true);
				mailMsg.setFrom(from);
				mailMsg.setTo(to);
				mailMsg.setSubject(subject);
				mailMsg.setText(body, true);
				FileSystemResource fileRes = new FileSystemResource(file);
				mailMsg.addAttachment(file.getName(), fileRes);
				mailSender.send(mimeMessage);
				} catch (Exception ex) {
					ex.printStackTrace(); 
				}
				}
				
}
