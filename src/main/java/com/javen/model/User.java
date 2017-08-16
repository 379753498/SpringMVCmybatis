package com.javen.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

/**
 * 
 *
 * CREATE TABLE `user` (
  `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` VARCHAR(60) DEFAULT NULL COMMENT '用户名',
   `Phone` VARCHAR(60) DEFAULT NULL COMMENT 'Phone',
    `Email` VARCHAR(60) DEFAULT NULL COMMENT 'Email',
  `EmailUUid` VARCHAR(60) DEFAULT NULL COMMENT 'EmailUUid',
  `state` INT(11) DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=INNODB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8

 *@Title:  
 *@Description:  
 *@Author:Administrator  
 *@Since:2017年7月21日  
 *@Version:1.1.0
 */
@Component
public class User implements Serializable {
	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getEmailUUid() {
		return EmailUUid;
	}

	public void setEmailUUid(String emailUUid) {
		EmailUUid = emailUUid;
	}



	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", state=" + state + ", password=" + password + ", Phone="
				+ Phone + ", Email=" + Email + ", EmailUUid=" + EmailUUid + "]";
	}



	@Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String username;
	private Integer state;
	private String password;
	private String Phone;
	private String Email;
	private String EmailUUid;
	

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

}
