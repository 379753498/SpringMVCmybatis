package com.javen.testmybatis;  


import org.springframework.context.ApplicationContext;

import com.javen.Redis.RedisUtil;



  
public class Springinit {

	
	public static void main(String[] args) {
		ApplicationContext applicationContextlzy = null ;
		try {
			 applicationContextlzy = ApplicationContextUitl.getApplicationContextlzy();

		} catch (Exception e) {
			// TODO: handle exception
		}
		
		RedisUtil bean = applicationContextlzy.getBean(RedisUtil.class);
		
//		bean.set("xujian", "chenggang");
//		Object object = bean.get("xujian");
//		
//		System.out.println(object.toString());
	}
}
