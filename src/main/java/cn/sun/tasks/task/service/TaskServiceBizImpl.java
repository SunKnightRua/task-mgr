package cn.sun.tasks.task.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sun.tasks.task.dao.TaskDao;
import cn.sun.tasks.task.domain.Task;
import cn.sun.tasks.timeactual.dao.TimeActualDao;
import cn.sun.tasks.timeactual.domain.TimeActual;
import cn.sun.tasks.timeexpected.dao.TimeExpectedDao;
import cn.sun.tasks.timeexpected.domain.TimeExpected;

@Service
public class TaskServiceBizImpl implements TaskService {

	@Autowired
	private TaskDao taskDao;
	@Autowired
	private TimeActualDao timeActualDao;
	@Autowired
	private TimeExpectedDao timeExpectedDao;

	// 获取所有任务
	@Override
	public List<Task> getAllTasks(Integer pageNo, Integer pageSize, String content, String desc, Byte priority,
			Byte isHabit, Byte isComplete) {
		List<Task> allTasks = taskDao.getAllTasks((pageNo - 1) * pageSize, pageSize, content, desc, priority, isHabit,
				isComplete);
		this.setIimeExpectedsAndTimeActuals(allTasks);
		return allTasks;
	}

	// 获取所有任务总数量
	@Override
	public int getAllTasksTotalCount(String content, String desc, Byte priority, Byte isHabit, Byte isComplete) {
		return taskDao.getAllTasksTotalCount(content, desc, priority, isHabit, isComplete);
	}

	// 根据id查询任务
	@Override
	public Task getTaskById(Integer id) {
		Task task = taskDao.getTaskById(id);
		List<TimeExpected> timeExpecteds = timeExpectedDao.getTimeExpectedsByTaskId(id);
		task.setTimeExpecteds(timeExpecteds);
		List<TimeActual> timeActuals = timeActualDao.getTimeActualsByTaskId(id);
		task.setTimeActuals(timeActuals);
		return task;
	}

	// 待办任务
	@Override
	public List<Task> getTodos(Integer pageNo, Integer pageSize) {
		List<Task> todos = taskDao.getTodos((pageNo-1)*pageSize, pageSize);
		this.setIimeExpectedsAndTimeActuals(todos);
		return todos;
	}
	//待办任务总数
	@Override
	public int getTodosTotalCount() {
		return taskDao.getTodosTotalCount();
	}

	// 当前任务
	@Override
	public List<Task> getPresentTasks(@Param("pageNo")Integer pageNo, @Param("pageSize")Integer pageSize) {
		return taskDao.getPresentTasks((pageNo-1)*pageSize, pageSize);
	}

	//当前任务总数
	public int getPresentTasksTotalCount(){
		return taskDao.getPresentTasksTotalCount();
	}
	
	
	// 逾期任务
	@Override
	public List<Task> getOverdueTasks(@Param("pageNo")Integer pageNo, @Param("pageSize")Integer pageSize) {
		return taskDao.getOverdueTasks((pageNo-1)*pageSize, pageSize);
	}
	
	//逾期任务总数
	@Override
	public int getOverdueTasksTotalCount() {
		return taskDao.getOverdueTasksTotalCount();
	}


	// 新增任务
	@Override
	public void addTask(Task task) {
		taskDao.insertTask(task);
		int taskId = task.getId();
		List<TimeExpected> timeExpecteds = task.getTimeExpecteds();
		if (timeExpecteds != null) {
			for (TimeExpected timeExpected : timeExpecteds) {
				timeExpected.setTaskId(taskId);
				timeExpectedDao.addTimeExpected(timeExpected);
			}
		}
		List<TimeActual> timeActuals = task.getTimeActuals();
		if (timeActuals != null) {
			for (TimeActual timeActual : timeActuals) {
				timeActual.setTaskId(taskId);
				timeActualDao.addTimeActual(timeActual);
			}
		}

	}

	//
	// // 更新任务
	// @Override
	// public void updateTask(Task task) {
	// // 获取timeExpecteds和timeActuals
	// List<TimeExpected> timeExpecteds = task.getTimeExpecteds();
	// List<TimeActual> timeActuals = task.getTimeActuals();
	// // 循环调用IimeExpected和TimeActual的update方法
	// taskDao.updateTask(task);
	// for(TimeExpected timeExpected:timeExpecteds) {
	// timeExpectedDao.updateTimeExpected(timeExpected);
	// }
	// for(TimeActual timeActual:timeActuals) {
	// timeActualDao.updateTimeActual(timeActual);
	//
	// }
	// }
	//
	// 删除任务
	@Override
	public void deleteTask(Integer id) {
		taskDao.deleteTask(id);
	}

	// 查询已完成任务
	@Override
	public List<Task> getCompletedTasks(Integer pageNo, Integer pageSize) {
		List<Task> completedTasks = taskDao.getCompletedTasks((pageNo - 1) * pageSize, pageSize);
		this.setIimeExpectedsAndTimeActuals(completedTasks);
		return completedTasks;
	}

	// 查询已完成任务数量
	@Override
	public int getCompletedTasksTotalCount() {
		return taskDao.getCompletedTasksTotalCount();
	}

	// @Override
	// public double getPercentOfCompletedTasks() {
	// Double percentOfCompletedTasks = new Double(0);
	// // 还需要排除其中被删除的
	// List<Task> completedTasks = this.getCompletedTasks();
	// // 还需要排除其中被删除的
	// List<Task> allTasks = taskDao.getAllTasks();
	// //
	// if (allTasks.size() != 0) {
	// percentOfCompletedTasks = completedTasks.size()*1.0 /
	// allTasks.size()*100;
	// }
	// return percentOfCompletedTasks;
	// }

	/**
	 * 为查询的Task结果查询timeExpecteds和timeActuals
	 * 
	 * @param allTasks目标任务集合
	 */
	private void setIimeExpectedsAndTimeActuals(List<Task> taskList) {
		for (Task task : taskList) {
			List<TimeExpected> timeExpecteds = timeExpectedDao.getTimeExpectedsByTaskId(task.getId());
			task.setTimeExpecteds(timeExpecteds);
		}
		for (Task task : taskList) {
			List<TimeActual> timeActuals = timeActualDao.getTimeActualsByTaskId(task.getId());
			task.setTimeActuals(timeActuals);
		}
	}

	
}
