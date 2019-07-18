package cn.sun.tasks.task.service;

import java.util.List;

import cn.sun.tasks.task.domain.Task;
import cn.sun.tasks.task.vo.TaskVo;

public interface TaskService {

	
	/**
	 * 查找所有任务
	 * @return 所有任务
	 */
	public abstract List<TaskVo> getAllTasks();
	
	/**
	 * 根据id查找任务
	 * @param id 任务对应的id
	 * @return 目标任务
	 */
	public abstract TaskVo getTaskById(Integer id);
	
	/**
	 * 根据id的集合查找任务
	 * @param list id的集合
	 * @return 目标任务的集合
	 */
	public List<TaskVo> getTaskByIds(List<Integer> ids);
	
	/**
	 * 插入一条任务
	 * @param task 任务信息
	 */
	public void insertTask(TaskVo taskVo);
	
	/**
	 * 更新一条任务
	 * @param task 任务信息
	 */
	public void updateTask(TaskVo taskVo);
	
	/**
	 * 根据id删除一条任务
	 * @param id 浠诲姟id
	 */
	public void deleteTask(Integer id);
	
	/**
	 * 查找已完成任务
	 * @return 已完成任务
	 */
	public List<TaskVo> getCompletedTasks();
	
	/**
	 * 查找逾期任务
	 * @return 逾期任务
	 */
	public List<TaskVo> getOverdueTasks();
	
	/**
	 * 查找待办任务
	 * @return 待办任务
	 */
	public List<TaskVo> getTodos();
	
	/**
	 * 查找当前任务
	 * @return 当前任务
	 */
	public List<TaskVo> getPresentTasks();
	
	/**
	 * 根据优先级查找任务
	 * @param priority 优先级
	 * @return 对应游侠你急的任务
	 */
	public List<TaskVo> getTasksByPriority(Enum priority);
	
	/**
	 * 计算已完成任务所占的比例
	 * @return 已完成任务所占的比例
	 */
	public double getPercentOfCompletedTasks();


}
