package com.javen.Config;

import java.security.GeneralSecurityException;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import com.sun.mail.util.MailSSLSocketFactory;

@Configuration
@PropertySource("classpath:mail.properties")
public class JavaMailConfig {

	 @Autowired
     Environment env;
	


	@Bean
	public JavaMailSenderImpl getJavaMailSenderImpl() {
		JavaMailSenderImpl JavaMailSenderImpl = new JavaMailSenderImpl();
		JavaMailSenderImpl.setHost(env.getProperty("mail.host"));
		JavaMailSenderImpl.setPort(Integer.parseInt(env.getProperty("mail.port")));
		JavaMailSenderImpl.setUsername(env.getProperty("mail.password"));
		JavaMailSenderImpl.setPassword(env.getProperty("mail.username"));
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
		SimpleMailMessage.setFrom(env.getProperty("mail.username"));
		return SimpleMailMessage;

	}
}
