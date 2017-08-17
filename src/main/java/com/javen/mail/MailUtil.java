package com.javen.mail;  
  
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;  
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;  
  
 @Component
public class MailUtil {  
	@Autowired
    private MailSender mailSender;  
	@Autowired
    private SimpleMailMessage simpleMailMessage;  
      

    /** 
     * 单发 
     * 
     * @param recipient 收件人 
     * @param subject 主题 
     * @param content 内容 
     */  
    public void send(String recipient,String subject,String content){  
        simpleMailMessage.setTo(recipient);  
        simpleMailMessage.setSubject(subject);  
        simpleMailMessage.setText(content);  
        mailSender.send(simpleMailMessage);  
    }  
      
    public void setMailSender(MailSender mailSender) {
		this.mailSender = mailSender;
	}

	public void setSimpleMailMessage(SimpleMailMessage simpleMailMessage) {
		this.simpleMailMessage = simpleMailMessage;
	}

	/** 
     * 群发 
     * 
     * @param recipients 收件人 
     * @param subject 主题 
     * @param content 内容 
     */  
    public void send(List<String> recipients,String subject,String content){  
        simpleMailMessage.setTo(recipients.toArray(new String[recipients.size()]));  
        simpleMailMessage.setSubject(subject);  
        simpleMailMessage.setText(content);  
        mailSender.send(simpleMailMessage);  
    }  
}  