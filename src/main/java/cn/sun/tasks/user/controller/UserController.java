package cn.sun.tasks.user.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.sun.tasks.user.domain.User;
import cn.sun.tasks.user.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public String register(){
		return "register.vm";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String register(String username, String password) {
		String id = UUID.randomUUID().toString().substring(5);
		//这里应该加上校验,判断用户是否已经存在
		
		User user = new User();
		if(username != null && password != null){
			user.setId(id);
			user.setUsername(username);
			user.setPassword(password);
			userService.register(id, username, password);
			return "redirect:/user/login";
		}else {
			return "forward:/user/register";
		}
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login() {
		return "login.vm";
	}
	
	/**
	 * 登录
	 * @param user
	 * @return
	 */
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(User user) {
 		if(userService.login(user.getUsername(), user.getPassword())){
			return "redirect:/task/listTasks";
		}else {
			return "forward:/login";
		}
	}
}
