package com.model;

import java.util.List;

import javax.ejb.Remote;

import com.entity.User;

@Remote
public interface UserRemote {
	public String insertData(User u)throws Exception;
	public List<User> readAll()throws Exception;
	public User findData(String name)throws Exception;
	public String updateData(String name, User data)throws Exception;
	public String deleteData(String name) throws Exception;

	
	
}
