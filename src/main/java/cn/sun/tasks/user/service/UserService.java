package cn.sun.tasks.user.service;

import java.util.List;

import cn.sun.tasks.user.domain.User;

public interface UserService {
	/**
	 * 查询所有用户
	 * @return
	 */
	public List<User> getAllUsers();
	
	/**
	 * 注册用户
	 * @param id
	 * @param username
	 * @param password
	 */
	public void register(String id, String username, String password);
	
	/**
	 * 登录
	 * @param username
	 * @param password
	 * @return
	 */
	public boolean login(String username, String password);
}
