package cn.sun.task.task.service;

import java.util.List;

import cn.sun.task.task.domain.Task;

public interface TaskService {

	/**
	 * 查询所有任务
	 * @return 今日所有任务
	 */
	public abstract List<Task> getAllTasks();
	
	/**
	 * 根据id查询任务
	 * @param id 传入的任务id
	 * @return 传入id对应的任务
	 */
	public abstract Task getTaskById(Integer id);
	
	/**
	 * 根据传入的id集合查询任务
	 * @param list 符合条件的任务id集合
	 * @return 符合条件的任务
	 */
	public List<Task> getTaskById(List<Integer> list);
	
	/**
	 * 新增一条任务
	 * @param task 任务信息
	 */
	public void insertTask(Task task);
	
	/**
	 * 更新任务
	 * @param task 任务信息
	 */
	public void updateTask(Task task);
	
	/**
	 * 删除任务
	 * @param id 任务id
	 */
	public void deleteTask(Integer id);
	
	/**
	 * 查询已完成任务
	 * @return 已完成任务
	 */
	public List<Task> getCompletedTasks();
	
	/**
	 * 获取逾期任务
	 * @return 逾期任务
	 */
	public List<Task> getOverdueTasks();
	
	/**
	 * 查找待办任务
	 * @return 待办任务
	 */
	public List<Task> getTodos();
	
	/**
	 * 查找当前任务
	 * @return 当前任务
	 */
	public List<Task> getPresentTasks();
	
	/**
	 * 根据优先级查找任务
	 * @param priority 优先级
	 * @return 对应优先级的任务
	 */
	public List<Task> getTasksByPriority(Enum priority);
	
	

//	6.	任务完成比例
	//是不是不应该在这里计算

}
