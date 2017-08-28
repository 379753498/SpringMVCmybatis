package com.javen.controller;  

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;






import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;








import com.javen.model.User;

import springfox.documentation.annotations.ApiIgnore;



@RestController  
@Api(value = "Shop")
@RequestMapping("/demo")
public class MyFirstSpringBootController { 



    @ApiOperation(value="获取指定id用户详细信息", notes="根据user的id来获取用户详细信息")
    @ApiImplicitParam(name = "id",value = "用户id", dataType = "String", paramType = "path")
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable String id ,Model m){
    	
        User user = new User();
   
        user.setPassword(id);
        user.setUsername("12345");
        m.addAttribute("User",user);
        return user;
    }

  

}
