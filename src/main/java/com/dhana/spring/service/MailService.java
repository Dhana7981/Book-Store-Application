package com.dhana.spring.service;

import java.io.File;

public interface MailService {
	public void sendMail(String from,String to,String subject,String body) ;
	public void sendMail(String from,String to,String subject,String body,File file) ;
}
