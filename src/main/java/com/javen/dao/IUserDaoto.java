package com.javen.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.javen.model.User;


public interface IUserDaoto  {

    
	String INSERTsql="INSERT  INTO `userinfo`(`username`,`password`,`Phone`,`Email`,`EmailUUid`,`state`) VALUES (#{username},#{password},#{Phone},#{Email},#{EmailUUid},0);";
	
	
    @Select("select * from userinfo where state = #{state}")
	public List<User> selectByState(Integer state);
    
    
    @Select("select * from userinfo where username = #{username}")
	public List<User> selectByUsername(User user);
    
//    @Select(" SELECT * FROM userinfo  t WHERE username = #{user.username,jdbcType=VARCHAR}  AND t.`password` = #{user.passwowrd,jdbcType=VARCHAR}")
//   	public List<User> selectUserpasswowrdcheck(@Param("user")User user);
    @Select("SELECT * FROM userinfo  t WHERE username = #{username,jdbcType=VARCHAR}  AND t.`password` = #{passwowrd,jdbcType=VARCHAR}")
    public List<User> selectUserpasswowrdcheck( @Param ("username") String  username ,  @Param ("passwowrd")  String password);
    
    @Select("select * from userinfo where EmailUUid = #{emailUUid}")
	public List<User> selectByemailUUid(User user);
    
    @Insert(INSERTsql)
    public int Insetuser(User user);
    @Update("update `userinfo` set state=1  where EmailUUid = #{emailUUid}")
    public int updateuserinfoforemailUUid(User user);
}