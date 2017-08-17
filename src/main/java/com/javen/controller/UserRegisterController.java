package com.javen.controller;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;  
import org.springframework.ui.Model;  
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.javen.mail.MailUtil;
import com.javen.model.User;
import com.javen.service.IUserService;
  
  
@Controller 
@RequestMapping("/")
public class UserRegisterController {  
	private static Logger log=LoggerFactory.getLogger(UserRegisterController.class);
	
	@Resource
	private IUserService UserServiceImpl;
	
	@Resource
	private MailUtil mail;

	
	@RequestMapping("/register.do")
	public String UserRegister( HttpServletRequest request, User user )
	
	
	{
		  String getContextPath = request.getContextPath();  
	
		user.setState(0);
		user.setEmailUUid(getRandomString(15));
		
		UserServiceImpl.Insetuser(user);
		System.out.println(user);
		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+getContextPath+"/"+user.getEmailUUid(); 

		mail.send(user.getEmail(), "淘宝网激活邮件", user.getUsername()+"您好 恭喜您注册成功 请点击下面的链接激活您的账户"+basePath+"/register.do");

		return "hello";
		
		
	}
	
	
	
	@RequestMapping("/checkUser.do")
	@ResponseBody
	public String checkUser( String username )
	{
		
		
		
		return "success";
		
		
	}
	
	
	@RequestMapping("/registercheck.do")
	@ResponseBody
	public String registercheck( User user )
	{
		
		
		return "success";
		
		
	}
	
	
	public static String getRandomString(int length) {
	    //随机字符串的随机字符库
	    String KeyString = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	    StringBuffer sb = new StringBuffer();
	    int len = KeyString.length();
	    for (int i = 0; i < length; i++) {
	       sb.append(KeyString.charAt((int) Math.round(Math.random() * (len - 1))));
	    }
	    return sb.toString();
	}
	
}  