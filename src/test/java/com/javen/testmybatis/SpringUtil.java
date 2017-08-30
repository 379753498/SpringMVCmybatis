package com.javen.testmybatis;  

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
/**
 * 非单态的方法
 */
public class SpringUtil implements ApplicationContextAware{

	private ApplicationContext applicationContext;
	@SuppressWarnings("unused")
	public SpringUtil()
	{

		
	ApplicationContext ctx=new  FileSystemXmlApplicationContext("classpath:**/applicationContext*.xml");
	this.applicationContext=ctx;
	//(**/applicationContext*.xml) 指的是任意一个文件下的applicationContext开头的xml文件
	//(classpath:**/applicationContext*.xml) 本项目下（不包含其他jar）指的是任意一个文件下的applicationContext开头的xml文件
	//(classpath*:applicationCo1ntext.xml) 所有项目下（包含其他jar）指的是src一个文件下的applicationContext开头的xml文件
	//(classpath:**/applicationContext*.xml) 本项目下（包含其他jar）指的是任意一个文件下的applicationContext开头的xml文件
	if(ctx!=null)
	{System.out.println("this is Spring context init ok");
	}
	else
	{
		System.out.println("this is Spring context init no ok");
		
	}
		
		
	}
	public ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	public void setApplicationContext(ApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
	}
	


}
