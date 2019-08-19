package cn.sun.tasks.user.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cn.sun.tasks.user.domain.User;

@Repository
public interface UserDao {
	public List<User> getAllUsers();
	
	public void insertUser(@Param("id")String id, @Param("username") String username, @Param("password")String password);

	public User getUserByUsername(String username);
}
