package com.javen.controller;  
  
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import java.awt.image.BufferedImage;










import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

/**
 * ClassName: CaptchaImageCreateController
 * Function: 生成验证码Controller.
 * date: 
 *
 * @author 
 */
@Api(value = "/tom")
@Controller
@RequestMapping("/myweb")
public class CaptchaImageCreateController {
	
		@Autowired
		@Qualifier("captchaProducer")
		 private Producer captchaProducer ;


	
  
    @ApiOperation(value="创建用户", notes="根据请求生成验证码")
    @ApiImplicitParams({
    	@ApiImplicitParam(dataType = "java.lang.String", name = "id", value = "id", required = true, paramType = "path")
    })
    @RequestMapping("/kaptcha.jpg/{id}.do")
    @ResponseBody
    public String handleRequest(HttpServletRequest request, HttpServletResponse response ,@PathVariable ("id") String id) throws Exception{
    	
    	System.out.println(id);
        // Set to expire far in the past.
        response.setDateHeader("Expires", 0);
        // Set standard HTTP/1.1 no-cache headers.
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
        // Set IE extended HTTP/1.1 no-cache headers (use addHeader).
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");
        // Set standard HTTP/1.0 no-cache header.
        response.setHeader("Pragma", "no-cache");

        // return a jpeg
        response.setContentType("image/jpeg");

        // create the text for the image
        String capText = captchaProducer.createText();

        // store the text in the session
        request.getSession().setAttribute(Constants.KAPTCHA_SESSION_KEY, capText);

        // create the image with the text
        BufferedImage bi = captchaProducer.createImage(capText);

        ServletOutputStream out = response.getOutputStream();

        // write the data out
        ImageIO.write(bi, "jpg", out);
        try {
            out.flush();
        } finally {
            out.close();
        }
        return capText;
    }
    
    
 
    
}