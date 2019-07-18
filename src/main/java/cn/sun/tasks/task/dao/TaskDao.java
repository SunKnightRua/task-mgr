package cn.sun.tasks.task.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.sun.tasks.task.domain.Task;
import cn.sun.tasks.task.vo.TaskVo;

@Repository
public interface TaskDao {

	
	public List<TaskVo> getAllTasks();
	public TaskVo getTaskById(Integer id);
	
	
	public void insertTask(TaskVo taskVo);
	public void updateTask(TaskVo taskVo);
	public void deleteTask(Integer id);
}
