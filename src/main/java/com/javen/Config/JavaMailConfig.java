package com.javen.Config;

import java.security.GeneralSecurityException;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import com.sun.mail.util.MailSSLSocketFactory;

@Configuration
public class JavaMailConfig {

	
	
	@Value("${mail.host}")
	String host;
	@Value("${mail.port}")
	int mailport;
	@Value("${mail.password}")
	String mailpassword;
	@Value("${mail.username}")
	String mailusername;

	@Bean
	public JavaMailSenderImpl getJavaMailSenderImpl() {
		JavaMailSenderImpl JavaMailSenderImpl = new JavaMailSenderImpl();
		JavaMailSenderImpl.setHost(host);
		JavaMailSenderImpl.setPort(mailport);
		JavaMailSenderImpl.setUsername(mailusername);
		JavaMailSenderImpl.setPassword(mailpassword);
		Properties p = new Properties();
		p.put("mail.smtps.auth", true);
		p.put("mail.smtp.ssl.enable", true);
		p.put("mail.transport.protocol", "smtp");
		JavaMailSenderImpl.setJavaMailProperties(p);
		return JavaMailSenderImpl;
	}

	@Bean
	public MailSSLSocketFactory getMailSSLSocketFactory()
			throws GeneralSecurityException {
		MailSSLSocketFactory MailSSLSocketFactory = new MailSSLSocketFactory();
		MailSSLSocketFactory.setTrustAllHosts(true);
		return MailSSLSocketFactory;
	}

	@Bean
	public SimpleMailMessage getSimpleMailMessage() {
		SimpleMailMessage SimpleMailMessage = new SimpleMailMessage();
		SimpleMailMessage.setFrom(mailusername);
		return SimpleMailMessage;

	}
}
