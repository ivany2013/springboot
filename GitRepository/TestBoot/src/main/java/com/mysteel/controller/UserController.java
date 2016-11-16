package com.mysteel.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.mysteel.entity.User;
import com.mysteel.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	private List<User> list;
	
	@RequestMapping(value="/users",method=RequestMethod.GET)
	public String selectAllUser(Map<String, Object> map,Integer pageNum){
		if(pageNum==null){
			pageNum=1;
		}
		
		int pages = (userService.selectAll().size())%4==0 ? (userService.selectAll().size())/4 :(userService.selectAll().size())/4 +1 ;
		
		PageHelper.startPage(pageNum, 4);
		list = userService.selectAll();
		
		
		
		map.put("list", list);
		map.put("pages", pages);
		map.put("pageNum", pageNum);
		return "index";
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.GET)
	public String deleteUser(Integer id){
		System.out.println(id);
		userService.deleteUser(id);
		return "redirect:/users";
	}
	
	@RequestMapping(value="/load",method=RequestMethod.GET,produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String loadByUser(Integer id,HttpServletRequest request){
		/*User user = userService.loadById(id);*/
		String result = "123123";
		return result;
	}
	
	@RequestMapping(value="/update",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String updateUser(Integer id ,String name,String sex,Integer age){
		User user = new User(id, name, sex, age);
		userService.updateUser(user);
		return null;
	}
	
	
	@RequestMapping("/insert")
	@ResponseBody
	public String insertUser(String name,String sex,Integer age){
		
		User user = new User(name, sex, age);
		Map<String, String> map = new HashMap<String, String>();
		System.out.println(user.getName());
		userService.insertUser(user);
		map.put("msg", "添加成功");
		String result = "12312312123123123";
		System.out.println(result);
		return result;
	}

	@RequestMapping("/index")
	public String index(){
		return "login";
	}
	
	@RequestMapping("/login")
	@ResponseBody
	public String login(String name ,Integer age,HttpServletRequest request){
		System.out.println(name+"===="+age);
		User user = userService.login(name, age);
		ObjectMapper mapper = new ObjectMapper();
		Map<String, String> map = new HashMap<String, String>();
		String result = null;
		try {
			if(user!=null){
				request.getSession().setAttribute("LOGIN_STATE", user);
				map.put("msg", "登录成功");
				map.put("success", "true");
				result = mapper.writeValueAsString(map);
		}else {
			map.put("msg", "登录失败");
			map.put("success", "false");
			result = mapper.writeValueAsString(map);
		}
			
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	@RequestMapping("/loadByName")
	@ResponseBody
	public String loadByName(String name,Integer age){
		User user = userService.loadByName(name);
		ObjectMapper mapper = new ObjectMapper();
		Map<String, String> map = new HashMap<String, String>();
		String result = null;
		try {
			if(user==null){
				String sex = "额";
				user = new User(name, sex, age);
				userService.insertUser(user);
				map.put("msg", "注册成功");
				map.put("success", "true");
				result = mapper.writeValueAsString(map);
		}else {
			map.put("msg", "用户名已存在");
			map.put("success", "false");
			result = mapper.writeValueAsString(map);
		}
			
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return result;
	}
	
}
