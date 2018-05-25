package com.javen.testmybatis;  


import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;

import com.javen.Redis.RedisUtil;
import com.javen.junit.MvcJunitRunApplication;


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
  
public class RedisTest extends MvcJunitRunApplication {
	@Autowired
	WebApplicationContext applicationContextlzy;
	@Test
	public void testone()
	{
		RedisUtil bean = applicationContextlzy.getBean(RedisUtil.class);
		bean.set("xujian", "WebApplicationContext");
		Object object = bean.get("xujian");
		System.out.println(object.toString());
	}
}
