package com.javen.interceptor.imp;  
  
import java.lang.reflect.Method;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import com.javen.interceptor.annotation.Tokenannotation;

public class TokenInterceptor extends HandlerInterceptorAdapter {
    private static final Logger LOG = Logger.getLogger(Tokenannotation.class);
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    	
    	if (handler instanceof HandlerMethod) {
    		
    		response.setHeader("Pragma", "No-cache");
    		response.setHeader("Cache-Control", "no-cache");
    		response.setDateHeader("Expires", 0);
        
        	System.out.println("我在拦截"+request.getRequestURL());
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Method method = handlerMethod.getMethod();
            Tokenannotation annotation = method.getAnnotation(Tokenannotation.class);
      
            if (annotation != null) {
                boolean needSaveSession = annotation.save();
                if (needSaveSession) {
                	
                    request.getSession(true).setAttribute("token", UUID.randomUUID().toString());
                }
                boolean needRemoveSession = annotation.remove();
                if (needRemoveSession) {
                    if (isRepeatSubmit(request)) {
                         LOG.warn("please don't repeat submit,url:"+ request.getServletPath());
                        return false;
                        
                    }
                    request.getSession(true).removeAttribute("token");
                }
            }
            return true;
        } else {
            return super.preHandle(request, response, handler);
        }
        
      
    }

    private boolean isRepeatSubmit(HttpServletRequest request) {
        String serverToken = (String) request.getSession(true).getAttribute("token");
        if (serverToken == null) {
            return true;
        }
        String clinetToken = request.getParameter("token");
     
        if (clinetToken == null) {
            return true;
        }
        if (!serverToken.equals(clinetToken)) {
            return true;
        }
        return false;
    }



}