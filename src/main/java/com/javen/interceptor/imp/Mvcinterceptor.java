package com.javen.interceptor.imp;

import java.lang.reflect.Method;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.text.rtf.RTFEditorKit;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.javen.interceptor.annotation.Sessionannotation;
import com.javen.interceptor.annotation.Tokenannotation;
import com.javen.model.User;

public class Mvcinterceptor extends HandlerInterceptorAdapter {
	private static final Logger LOG = Logger.getLogger(Tokenannotation.class);

	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		boolean isok= true;
		if (handler instanceof HandlerMethod) {
			
			
			HttpSession session = request.getSession();

			HandlerMethod handlerMethod = (HandlerMethod) handler;
			Method method = handlerMethod.getMethod();
			Sessionannotation Sessionannotation = method.getAnnotation(Sessionannotation.class);
		
		 if(Sessionannotation!=null)
		 {
			 isok= lsok(request,response);
		
			 
		 }

		}
		return isok;

	}

	private boolean lsok(HttpServletRequest request, HttpServletResponse Response ) {
		try {
			System.out.println(request.getServletPath());
			if (!(request.getServletPath().contains("/login")) ) {
					
				User attribute = (User) request.getSession().getAttribute("user");
				if (attribute == null) {
					LOG.warn("NO  session User,url:" + request.getServletPath());
					Response.sendRedirect(request.getContextPath()+"/login");
					return false;
				}
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return true;
	}
}