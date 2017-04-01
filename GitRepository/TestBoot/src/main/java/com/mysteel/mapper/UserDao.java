package com.mysteel.mapper;

import java.util.List;

import com.mysteel.entity.User;



public interface UserDao {
	
	List<User> selectAll();
	
	void deleteUser(Integer id);
	
	void insertUser(User user);
	
	User loadById(Integer id);
	
	void updateUser(User user);
	
	User login(String name,String password);
	
	User loadByName(String name);
}
