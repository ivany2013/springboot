package com.mysteel.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.mysteel.Application;
import com.mysteel.Config.RedisClient;
import com.mysteel.entity.User;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class RedisTest {
	
	@Autowired
	private RedisClient client;
	
//	@Test
	public void testSet(){
		User user = new User("111", "22", 3, "444");
//		client.setObj("user", user);
		try {
			
			client.setObjSel("seluser", user);
//			client.set("test", "1234");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGet(){
		User user = (User) client.getObjSel("seluser");
		try {
			System.out.println(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(user.getName());
	}
}
