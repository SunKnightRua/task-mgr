package cn.sun.tasks.task.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sun.tasks.task.dao.TaskDao;
import cn.sun.tasks.task.domain.Task;

@Service
public class TaskServiceBizImpl implements TaskService {

	@Autowired 
	private TaskDao taskDao;
	
	@Override
	public List<Task> getAllTasks() {

		List<Task> tasks =taskDao.getAllTasks();
		return tasks;
	}

	@Override
	public Task getTaskById(Integer id) {

		Task task = taskDao.getTaskById(id);
		return task;
	}

	@Override
	public List<Task> getTaskById(List<Integer> list) {

		List<Task> tasks =new ArrayList<Task>();
		if(list != null){
			for(Integer id : list){
				tasks.add(taskDao.getTaskById(id));
			}
		}
		return tasks;
	}

	@Override
	public void insertTask(Task task) {

		taskDao.insertTask(task);
	}

	@Override
	public void updateTask(Task task) {

		taskDao.updateTask(task);
	}

	@Override
	public void deleteTask(Integer id) {

		taskDao.deleteTask(id);
	}

	@Override
	public List<Task> getCompletedTasks() {
		
		List<Task> completedTasks = taskDao.getCompletedTasks();
		return completedTasks;
	}

	@Override
	public List<Task> getOverdueTasks() {
//		1.有实际完成时间
//			已完成
//				最大实际完成时间>最大期望完成时间
//			未完成
//				当前系统时间>最大期望完成时间

//		2.没有实际完成时间，根据当前判断
//			任务未完成且当前时间大于最大期望完成时间
		
		return null;
	}

	@Override
	public List<Task> getTodos() {
		
		List<Task> todos=taskDao.getTodos();
		return todos;
	}

	@Override
	public List<Task> getPresentTasks() {
		List<Task> presentTasks = taskDao.getPresentTasks();
		return presentTasks;
	}

	@Override
	public List<Task> getTasksByPriority(Enum priority) {
		List<Task> tasks = taskDao.getTasksByPriority(priority);
		return tasks;
	}
	

}
