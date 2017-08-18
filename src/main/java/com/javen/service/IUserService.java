package com.javen.service;  

import java.util.List;

import com.javen.model.User;
  
  
public interface IUserService {  
    public User getUserById(int userId);  
    
    public List<User> selectByState(Integer state);
    
    public List<User> selectByname(User user);
    public int Insetuser(User user);
    public List<User> selectByemailUUid(User user);
    public int updateuserinfoforemailUUid(User user);
    
	public List<User> selectUserpasswowrdcheck(User user);
}  