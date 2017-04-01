package com.mysteel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mysteel.entity.User;
import com.mysteel.mapper.UserDao;

@Service
@Transactional
public class UserService {
	@Autowired
	private UserDao dao;
	
	public List<User> selectAll(){
		return dao.selectAll();
	}
	
	public void deleteUser(Integer id){
		dao.deleteUser(id);
	}
	
	public void insertUser(User user){
		dao.insertUser(user);
	}
	
	
	public User loadById(Integer id){
		return dao.loadById(id);
	}
	
	public void updateUser(User user){
		dao.updateUser(user);
	}
	
	public User login(String name,String password){
		return dao.login(name, password);
	}
	
	public User loadByName(String name){
		return dao.loadByName(name);
	}
}
