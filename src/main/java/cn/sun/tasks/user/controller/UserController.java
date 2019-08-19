package cn.sun.tasks.user.controller;

import java.util.UUID;

import org.apache.jasper.tagplugins.jstl.core.Redirect;
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
	
	@RequestMapping("/register")
	public String register(String username, String password) {
		String id = UUID.randomUUID().toString().substring(5);
		//这里应该加上校验,判断用户是否已经存在
		
		User user = new User();
		user.setId(id);
		user.setUsername(username);
		user.setPassword(password);
		return "redirect:/task/getAllTasks?pageNo=1&pageSize=10&content=&desc=&priority=&isHabit=&isComplete=";
	}
	
	/**
	 * 登录
	 * @param user
	 * @return
	 */
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(User user) {
 		if(userService.login(user.getUsername(), user.getPassword())){
			return "redirect:/task/getAllTasks?pageNo=1&pageSize=10&content=&desc=&priority=&isHabit=&isComplete=";
		}else {
			return "forward:/login";
		}
	}
}
