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
	 * 
	 * @param isComplete
	 * @param isHabit
	 * @param priority
	 * @param desc
	 * @param content
	 * @return
	 */
	public List<Task> getAllTasks(@Param("start") Integer start, @Param("offset") Integer offset,
			@Param("content") String content, @Param("desc") String desc, @Param("priority") Byte priority,
			@Param("isHabit") Byte isHabit, @Param("isComplete") Byte isComplete);

	/**
	 * 获取所有任务总数量
	 * 
	 * @return
	 */
	public int getAllTasksTotalCount(@Param("content") String content, @Param("desc") String desc,
			@Param("priority") Byte priority, @Param("isHabit") Byte isHabit, @Param("isComplete") Byte isComplete);

	/**
	 * 、根据id获取任务
	 * 
	 * @param id
	 * @return
	 */
	public Task getTaskById(Integer id);

	/**
	 * 新增任务
	 * 
	 * @param task
	 * @return
	 */
	public Integer insertTask(Task task);

	/**
	 * 更新任务
	 * 
	 * @param task
	 */
	public void updateTask(Task task);

	/**
	 * 删除任务
	 * 
	 * @param id
	 */
	public void deleteTask(Integer id);

	/**
	 * 查询已完成任务
	 * 
	 * @param start从第start条已完成任务开始查询
	 * @param offset每个页面显示的数量
	 * @return已完成任务
	 */
	public List<Task> getCompletedTasks(@Param("start") Integer start, @Param("offset") Integer offset);

	/**
	 * 查询已完成任务数量
	 * @return已完成任务数量
	 */
	public int getCompletedTasksTotalCount();
	
	
}
