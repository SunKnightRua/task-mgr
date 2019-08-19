package cn.sun.tasks.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sun.tasks.user.dao.UserDao;
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
	public boolean login(String username, String password) {
		boolean flag = false;
		User user1=userDao.getUserByUsername(username);
		if(password !=null && password.equals(user1.getPassword())){
			flag = true;
		}
		return flag;
	}

}
