package com.javen.junit;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.javen.Config.RootConfig;


@RunWith(SpringJUnit4ClassRunner.class)//使用Springjunit运行环境
@WebAppConfiguration()//webapp 路径 默认为src/main/webapp
@ContextConfiguration(classes={RootConfig.class})//Application配置文件或者javaConfig 配置类
//@Transactional //开启事务
public class MvcJunitRunApplication {

	public MockMvc mockMvc;
	
	@Autowired	
	WebApplicationContext wac;
	

	 @Before
	    public void setUp() throws Exception {
		 this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
		 System.err.println("mockMvc运行环境已完成可以使用super.mockMvc.perform进行 测试");

	    }
	 
	 

}
