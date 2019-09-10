package cn.sun.tasks.task.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cn.sun.tasks.task.domain.Task;

@Repository
public interface TaskDao {

	/**
	 * 获取所有任务
	 */
	public List<Task> listTasks(@Param("start") Integer start, @Param("offset") Integer offset,
			@Param("content") String content, @Param("desc") String desc, @Param("priority") Byte priority,
			@Param("isHabit") Byte isHabit, @Param("isComplete") Byte isComplete);

	/**
	 * 获取所有任务总数量
	 */
	public int countListTasks(@Param("content") String content, @Param("desc") String desc,
			@Param("priority") Byte priority, @Param("isHabit") Byte isHabit, @Param("isComplete") Byte isComplete);

	/**
	 * 、根据id获取任务
	 */
	public Task getTaskById(Integer id);

	/**
	 * 新增任务
	 */
	public Integer insertTask(Task task);

	/**
	 * 更新任务
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
	 */
	public List<Task> getCompletedTasks(@Param("start") Integer start, @Param("offset") Integer offset);

	/**
	 * 查询已完成任务数量
	 */
	public int getCompletedTasksTotalCount();

	/**
	 * 查询待办任务
	 */
	public List<Task> getTodos(@Param("start") Integer start, @Param("offset") Integer offset);

	/**
	 * 查询待办任务总数
	 */
	public int getTodosTotalCount();

	/**
	 * 查询当前任务
	 */
	public List<Task> getPresentTasks(@Param("start") Integer start, @Param("offset") Integer offset);

	/**
	 * 查询当前任务总数
	 */
	public int getPresentTasksTotalCount();

	/**
	 * 查询逾期任务
	 */
	public List<Task> getOverdueTasks(@Param("start") Integer start, @Param("offset") Integer offset);

	/**
	 * 查询逾期任务总数
	 */
	public int getOverdueTasksTotalCount();

}
