package com.javen.mail;  
  
import java.security.GeneralSecurityException;
import java.util.List;
import java.util.Properties;

import javax.mail.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;  
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;  

import com.sun.mail.util.MailSSLSocketFactory;
  
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
    
	public static Session Sessioninit() throws GeneralSecurityException {
		
		Properties props = new Properties();

          // 开启debug调试
          props.setProperty("mail.debug", "true");
          // 发送服务器需要身份验证
          props.setProperty("mail.smtp.auth", "true");
          // 设置邮件服务器主机名
          props.setProperty("mail.host", "smtp.qq.com");
          // 发送邮件协议名称
          props.setProperty("mail.transport.protocol", "smtp");

          MailSSLSocketFactory sf = new MailSSLSocketFactory();
          sf.setTrustAllHosts(true);
          props.put("mail.smtp.ssl.enable", "true");
          props.put("mail.smtp.ssl.socketFactory", sf);
          
          Session session = Session.getInstance(props);
		return session;
	}
    
    
}  