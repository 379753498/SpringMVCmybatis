package com.javen.testmybatis;  
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



/**
 * 单例模式的ApplicationContext 
 * 
 */
 final public class ApplicationContextUitl {

	
	 private static ApplicationContext ApplicationContext=null;
	
	 private ApplicationContextUitl()
	 {
		 System.out.println("构造函数被调用");
	 }

//	static
//	{
//		ApplicationContext = new FileSystemXmlApplicationContext(
//				"classpath:**/applicationContext*.xml");
//	}
/**静态方法方式单例模式 没有实现懒加载
 * 
 * @return  
 * @Description:
 */
	public static ApplicationContext getApplicationContext() {
		return ApplicationContext;
	}
	
	public static ApplicationContext SetApplicationContext(ApplicationContext ApplicationContext) {
		ApplicationContextUitl.ApplicationContext=ApplicationContext;
		return ApplicationContextUitl.ApplicationContext;
	}
	
	/**
	 * 实现懒加载
	 */
	  public static ApplicationContext getApplicationContextlzy() {  
	        if (ApplicationContext == null) {  
	        	ApplicationContext =  new ClassPathXmlApplicationContext("classpath:spring-mybatis.xml"); 
	        }  
	       
	        SetApplicationContext(ApplicationContext);
	        return ApplicationContext;  
	    }  
	
	
}
