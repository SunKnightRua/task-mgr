package cn.sun.tasks.task.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.sun.tasks.task.domain.Task;

public interface TaskService {

	/**
	 * 查询所有任务
	 * 
	 * @param isComplete
	 * @param isHabit
	 * @param priority
	 * @param desc
	 * @param content
	 * @return 所有任务
	 */
	public abstract List<Task> getAllTasks(Integer pageNo, Integer pageSize, String content, String desc, Byte priority,
			Byte isHabit, Byte isComplete);

	/**
	 * 查询所有任务总数量
	 * 
	 * @return 所有任务总数量
	 */
	public abstract int getAllTasksTotalCount(String content, String desc, Byte priority, Byte isHabit,
			Byte isComplete);

	/**
	 * 根据id查询任务
	 * 
	 * @param id
	 *            任务对应的id
	 * @return 目标任务
	 */
	public abstract Task getTaskById(Integer id);

	/**
	 * 插入一条任务
	 * 
	 * @param task任务信息
	 */
	public void addTask(Task task);

	//
	// /**
	// * 更新一条任务
	// * @param task 任务信息
	// */
	// public void updateTask(Task task);
	//
	/**
	 * 根据id删除一条任务
	 * 
	 * @param id任务id
	 */
	public void deleteTask(Integer id);

	/**
	 * 查询已完成任务
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public List<Task> getCompletedTasks(Integer pageNo, Integer pageSize);

	/**
	 * 查询已完成任务总数
	 * 
	 * @return已完成任务总数
	 */
	public int getCompletedTasksTotalCount();

	/**
	 * 查询逾期任务
	 * 
	 * @return 逾期任务
	 */
	public List<Task> getOverdueTasks(Integer pageNo, Integer pageSize);

	/**
	 * 查询逾期任务总数
	 * 
	 * @return
	 */
	public int getOverdueTasksTotalCount();

	/**
	 * 查询待办任务
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public List<Task> getTodos(Integer pageNo, Integer pageSize);

	/**
	 * 查询待办任务总数
	 * 
	 * @return待办任务总数
	 */
	public int getTodosTotalCount();

	/**
	 * 查询当前任务
	 * 
	 * @return 当前任务
	 */
	public List<Task> getPresentTasks(Integer pageNo, Integer pageSize);

	/**
	 * 查询当前任务总数
	 * 
	 * @return
	 */
	public int getPresentTasksTotalCount();

	// /**
	// * 计算已完成任务所占的比例
	// * @return 已完成任务所占的比例
	// */
	// public double getPercentOfCompletedTasks();
	//

}
