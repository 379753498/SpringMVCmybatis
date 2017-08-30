package com.javen.testmybatis;  


import org.springframework.context.ApplicationContext;

import com.javen.Redis.RedisUtil;


/**
 * 
 * 如要进行此项测试需要将SwaggerConfig 中注解在类头上的注解取消否则会报错
 * Windows  需要安装redis服务功能  安装详细请参阅http://www.runoob.com/redis/redis-install.html
 *@Title:  
 *@Description:  
 *@Author:Administrator  
 *@Since:2017年8月30日  
 *@Version:1.1.0
 */
  
public class RedisTest {

	
	public static void main(String[] args) {
		ApplicationContext applicationContextlzy = null ;
		try {
			 applicationContextlzy = ApplicationContextUitl.getApplicationContextlzy();

		} catch (Exception e) {
			// TODO: handle exception
		}
		
		RedisUtil bean = applicationContextlzy.getBean(RedisUtil.class);
		bean.set("xujian", "程刚....redis");
		Object object = bean.get("xujian");
		System.out.println(object.toString());
	}
}
