package com.javen.testmybatis;

import javax.annotation.Resource;  

import org.apache.log4j.Logger;  
import org.junit.Test;
import org.springframework.web.context.WebApplicationContext;

import com.alibaba.fastjson.JSON;  
import com.javen.junit.MvcJunitRunApplication;
import com.javen.model.User;
import com.javen.service.IUserService;
  

public class TestMyBatis  extends MvcJunitRunApplication {  
    private static Logger logger = Logger.getLogger(TestMyBatis.class); 
    
    @Resource  
    private WebApplicationContext WebApplicationContext ;  
    @Resource  
    private IUserService userService = null;  
  

  
    @Test  
    public void test1() {  
        User user = userService.getUserById(2);  
        logger.info(JSON.toJSONString(user));  
    }  
}  