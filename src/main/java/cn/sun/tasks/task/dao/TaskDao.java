package cn.sun.tasks.task.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.sun.tasks.task.domain.Task;

@Repository
public interface TaskDao {

	
	public List<Task> getAllTasks();
	public Task getTaskById(Integer id);
	
	
	public void insertTask(Task task);
	public void updateTask(Task task);
	public void deleteTask(Integer id);
}
