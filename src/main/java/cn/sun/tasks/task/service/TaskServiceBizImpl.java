package cn.sun.tasks.task.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sun.tasks.task.dao.TaskDao;
import cn.sun.tasks.task.domain.Task;
import cn.sun.tasks.timeexpected.domain.TimeExpected;

@Service
public class TaskServiceBizImpl implements TaskService {

	@Autowired 
	private TaskDao taskDao;
	
	@Override
	public List<Task> getAllTasks() {
		List<Task> allTasks = taskDao.getAllTasks();
		return allTasks;
	}
	
	@Override
	public Task getTaskById(Integer id) {
		Task task = taskDao.getTaskById(id);
		return task;
	}
	
	@Override
	public List<Task> getTaskByIds(List<Integer> ids) {
		List<Task> taskList = new ArrayList<Task>();
		if(ids != null) {
			for(Integer id : ids) {
				taskList.add(taskDao.getTaskById(id));
			}
		}
		return taskList;
	}
	
	@Override
	public List<Task> getTodos() {
		List<Task> todos = new ArrayList<>();
		//获取所有任务，将符合条件的任务添加进todos
		List<Task> allTasks = taskDao.getAllTasks();
//		获取当前时间
		Date curtime =new Date();
		for(Task task : allTasks) {
			if(task.getIsDelete() != 1 && task.getIsComplete() !=1){
//				实际开始时间为空
				if(task.getTimeActuals() == null) {
					List<TimeExpected> timeExpecteds = task.getTimeExpecteds();
//					当前时间小于最大期望完成时间
					if(curtime.before(this.getMaxEndTimeExpected(timeExpecteds))){
						todos.add(task);
					}
				}
			}
		}
		return todos;
	}

	@Override
	public List<Task> getPresentTasks() {
		List<Task> presentTasks = new ArrayList<>();
		//获取所有任务，将符合条件的任务添加进presentTasks
		List<Task> allTasks = taskDao.getAllTasks();
		//获取当前系统时间
		Date curtime = new Date();
		for(Task task : allTasks) {
			if(task.getIsDelete() != 1 && task.getIsComplete() !=1){
//				实际开始时间不为空
				if(task.getTimeActuals() != null) {
					List<TimeExpected> timeExpecteds = task.getTimeExpecteds();
//					当前时间<最大期望完成时间
					if(curtime.before(this.getMaxEndTimeExpected(timeExpecteds))){
						presentTasks.add(task);
					}
				}
			}
		}
		
		return presentTasks;
	}

	@Override
	public List<Task> getTasksByPriority(Integer priority) {
		List<Task> taskList = new ArrayList<>();
		//获取所有任务，将符合条件的任务添加进taskList
		List<Task> allTasks = taskDao.getAllTasks();
		for(Task task : allTasks) {
			if(task.getIsDelete() != 1 && task.getIsComplete() !=1){
				if(priority.equals(task.getPriority())) {
					taskList.add(task);
				}
			}
		}
		
		return taskList;
	}

	@Override
	public List<Task> getOverdueTasks() {
		List<Task> overdueTasks = new ArrayList<>();
//		获取所有任务，将符合条件的任务添加进overdueTasks
		List<Task> allTasks = taskDao.getAllTasks();
//		获取当前时间
		Date curtime = new Date();
		
		for(Task task : allTasks) {
			if(task.getIsDelete() != 1){
//				1.有实际完成时间
//				实际完成时间不为空
//						已完成
//							最大实际完成时间>最大期望完成时间
//						未完成
//							当前系统时间>最大期望完成时间
//				2.没有实际完成时间，根据当前判断
//				1任务未完成
//				2当前时间大于最大期望完成时间
			}
		}
		
		return overdueTasks;
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
		List<Task> completedTasks = new ArrayList<>();
		
		List<Task> allTasks = taskDao.getAllTasks();
		for(Task task : allTasks) {
			if(task.getIsComplete() == 1) {
				completedTasks.add(task);
			}
		}
		
		return completedTasks;
	}

	@Override
	public double getPercentOfCompletedTasks() {
		Double percentOfCompletedTasks = new Double(0);
		List<Task> completedTasks=this.getCompletedTasks();
		List<Task> allTasks = taskDao.getAllTasks();
		if(allTasks.size() !=0){
			percentOfCompletedTasks = (double) (completedTasks.size()/allTasks.size());
		}
		
		return percentOfCompletedTasks;
	}
	
	
	//获取最大预期时间
	public Date getMaxEndTimeExpected(List<TimeExpected> timeExpecteds) {
		
		List<Date> endTimeExpecteds = new ArrayList<>();
		for(TimeExpected timeExpected :timeExpecteds) {
			endTimeExpecteds.add(timeExpected.getEndTimeExpected());
		}
		Collections.sort(endTimeExpecteds);
		return endTimeExpecteds.get(endTimeExpecteds.size()-1);
	}
	
	//获取最小预期时间
	public Date getMinEndTimeExpected(List<TimeExpected> timeExpecteds) {
		
		List<Date> endTimeExpecteds = new ArrayList<>();
		for(TimeExpected timeExpected :timeExpecteds) {
			endTimeExpecteds.add(timeExpected.getEndTimeExpected());
		}
		
		Collections.sort(endTimeExpecteds);
		return endTimeExpecteds.get(0);
	}
	
}
