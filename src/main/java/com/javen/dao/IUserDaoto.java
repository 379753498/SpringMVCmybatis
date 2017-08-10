package com.javen.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.javen.model.User;


public interface IUserDaoto  {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    @Select("select * from user where state = #{state}")
	public List<User> selectByState(Integer state);
    
    
}