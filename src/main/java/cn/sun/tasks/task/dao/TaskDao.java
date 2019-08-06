package cn.sun.tasks.task.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Repository;

import cn.sun.tasks.task.domain.Task;

@Repository
public interface TaskDao {

	/**
	 * 获取所有任务
	 * @return
	 */
	public List<Task> getAllTasks(@Param("start")Integer start, @Param("offset")Integer offset);
	
	/**
	 * 获取所有任务总数量
	 * @return
	 */
	public int getAllTasksTotalCount();
	
	/**
	 * 、根据id获取任务
	 * @param id
	 * @return
	 */
	public Task getTaskById(Integer id);
	
	/**
	 * 新增任务
	 * @param task
	 * @return
	 */
	public Integer insertTask(Task task);
	
	/**
	 * 更新任务
	 * @param task
	 */
	public void updateTask(Task task);
	
	/**
	 * 删除任务
	 * @param id
	 */
	public void deleteTask(Integer id);

}
