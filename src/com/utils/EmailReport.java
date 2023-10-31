package com.utils;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class EmailReport {
	
	static Email email = new SimpleEmail();
	public static void sendEmail() throws EmailException{
	email.setHostName("smtp.gmail.com");
	email.setSmtpPort(587);
	email.setAuthenticator(new DefaultAuthenticator("persistent.mountsinai@gmail.com", "PSL@12345"));
	email.setSSLOnConnect(true);
	email.setFrom("persistent.mountsinai@gmail.com");
	email.setSubject("TestMail");
	email.setMsg("This is a test mail ... :-)");
	email.addTo("persistent.mountsinai@gmail.com");
	email.send();
	}

}
