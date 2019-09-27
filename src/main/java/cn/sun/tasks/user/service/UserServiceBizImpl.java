package cn.sun.tasks.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sun.tasks.user.dao.UserDao;
import cn.sun.tasks.user.domain.ActiveUser;
import cn.sun.tasks.user.domain.User;

@Service
public class UserServiceBizImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Override
	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}
	
	@Override
	public void register(String id, String username, String password) {
		userDao.insertUser(id, username, password);
	}

	@Override
	public User getUserByUsername(String username) {
	    User user=userDao.getUserByUsername(username);
		return user;
	}

}
