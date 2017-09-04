package com.javen.controller;  

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.javen.model.User;
import com.javen.service.IUserService;

@Controller  
@RequestMapping("/login")
public class LoginContoller {
	@Resource
	private IUserService UserService;
	
	
	/**
     * loginCheck:ajax异步校验登录请求. <br/>
     *
     * @author 
     * @param request
     * @param kaptchaReceived 验证码
     * @return 校验结果
     * @since 
     */
    @RequestMapping(value = "check.do", method = RequestMethod.POST)
    @ResponseBody
    public String loginCheckkaptcha(HttpServletRequest request,@RequestParam(value = "kaptcha", required = true) String kaptchaReceived){
        //用户输入的验证码的值
        String kaptchaExpected = (String) request.getSession().getAttribute(
                com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);

        //校验验证码是否正确
        if (kaptchaReceived == null || !kaptchaReceived.equals(kaptchaExpected)) {
            return "error";//返回验证码错误
        }
        //校验用户名密码
        // ……
        // ……
        return "success"; //校验通过返回成功
    }
    
    
    @RequestMapping(value = "login", method = RequestMethod.POST)
    @ResponseBody
    public String login(HttpServletRequest request,@RequestParam(value = "kaptcha", required = true) String kaptchaReceived,User user){
        //用户输入的验证码的值
    	
        String kaptchaExpected = (String) request.getSession().getAttribute(
                com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);

        //校验验证码是否正确
        if (kaptchaReceived == null || !kaptchaReceived.equals(kaptchaExpected)) {

            return "login";//返回验证码错误
        }
        //校验用户名密码
        // ……
        // ……
        System.out.println(user);
        List<User> selectUserpasswowrdcheck = UserService.selectUserpasswowrdcheck(user);
        
        System.out.println(selectUserpasswowrdcheck);
        if(selectUserpasswowrdcheck.size()==1)
        {	
        	request.getSession().setAttribute("user", user);
        	 return "main";
        }
        else
        {
        	 return "login";//返回验证码错误
        }
		
       
    }
    
  

}
