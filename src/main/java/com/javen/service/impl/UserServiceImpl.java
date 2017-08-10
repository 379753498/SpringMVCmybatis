package com.javen.service.impl;
import java.util.List;

import javax.annotation.Resource;  
  





import org.springframework.stereotype.Service;  

import com.javen.dao.IUserDao;
import com.javen.dao.IUserDaoto;
import com.javen.model.User;
import com.javen.service.IUserService;
  
  
@Service("userService")  
public class UserServiceImpl implements IUserService {  
    @Resource  
    private IUserDaoto IUserDaoto;  
    
    public User getUserById(int userId) {  
        // TODO Auto-generated method stub  
        return this.IUserDaoto.selectByPrimaryKey(userId);  
    }

	public List<User> selectByState(Integer state) {
		// TODO Auto-generated method stub  
		return IUserDaoto.selectByState(state);
	}  
  
}  
