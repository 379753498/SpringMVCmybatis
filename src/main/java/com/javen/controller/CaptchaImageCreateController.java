package com.javen.controller;  
  

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.javen.Captcha.Captcha;
import com.javen.Captcha.GifCaptcha;

/**
 * ClassName: CaptchaImageCreateController
 * Function: 生成验证码Controller.
 * date: 
 *
 * @author 
 */

@Controller
@RequestMapping("/myweb")
public class CaptchaImageCreateController {
	
		@Autowired
		@Qualifier("captchaProducer")
		 private Producer captchaProducer ;
		
//    @RequestMapping("/kaptcha.jpg/{id}.do")//此处使用动态参数解决验证码不更新问题IE
//    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response ) throws Exception{
//    	
//        // Set to expire far in the past.
//        response.setDateHeader("Expires", 0);
//        // Set standard HTTP/1.1 no-cache headers.
//        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
//        // Set IE extended HTTP/1.1 no-cache headers (use addHeader).
//        response.addHeader("Cache-Control", "post-check=0, pre-check=0");
//        // Set standard HTTP/1.0 no-cache header.
//        response.setHeader("Pragma", "no-cache");
//        // return a jpeg
//        response.setContentType("image/jpeg");
//        // create the text for the image
//        String capText = captchaProducer.createText();
//        // store the text in the session
//        request.getSession().setAttribute(Constants.KAPTCHA_SESSION_KEY, capText);
//        // create the image with the text
//        BufferedImage bi = captchaProducer.createImage(capText);
//        ServletOutputStream out = response.getOutputStream();
//
//        // write the data out
//        ImageIO.write(bi, "jpg", out);
//        try {
//            out.flush();
//        } finally {
//            out.close();
//        }
//        return null;
//    }
//    
    
	    @RequestMapping("/kaptcha.jpg/{id}.do")//此处使用动态参数解决验证码不更新问题IE
	    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response ) throws Exception{
	    	
	    	response.setHeader("Pragma", "No-cache");  
	        response.setHeader("Cache-Control", "no-cache");  
	        response.setDateHeader("Expires", 0);  
	        response.setContentType("image/gif");  
	        Captcha captcha = new GifCaptcha(146,33,6);
	        
	        captcha.out(response.getOutputStream());
	        HttpSession session = request.getSession(true);  
	        //存入Session
	        session.setAttribute(Constants.KAPTCHA_SESSION_KEY,captcha.text().toLowerCase());  
	       
	        return null;
	    }
	    
 
    
}