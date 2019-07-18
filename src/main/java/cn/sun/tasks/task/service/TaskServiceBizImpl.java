package cn.sun.tasks.task.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.omg.PortableInterceptor.INACTIVE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sun.tasks.task.dao.TaskDao;
import cn.sun.tasks.task.domain.Task;
import cn.sun.tasks.task.vo.TaskVo;

@Service
public class TaskServiceBizImpl implements TaskService {

	@Autowired 
	private TaskDao taskDao;
	
	@Override
	public List<TaskVo> getAllTasks() {
		List<TaskVo> allTasks = taskDao.getAllTasks();
		return allTasks;
	}
	
	@Override
	public TaskVo getTaskById(Integer id) {
		TaskVo task = taskDao.getTaskById(id);
		return task;
	}
	
	@Override
	public List<TaskVo> getTaskByIds(List<Integer> ids) {
		List<TaskVo> taskList = new ArrayList<TaskVo>();
		if(ids != null) {
			for(Integer id : ids) {
				taskList.add(taskDao.getTaskById(id));
			}
		}
		return taskList;
	}
	
	@Override
	public List<TaskVo> getTodos() {
		List<TaskVo> todos = new ArrayList<>();
		//获取所有任务，将符合条件的任务添加进todos
		List<TaskVo> allTasks = taskDao.getAllTasks();
		Date date =new Date();
		for(TaskVo task : allTasks) {
			if(task.getIsDelete() != 1 && task.getIsComplete() !=1){
				if(task.getBeginTimeActual() == null) {
					if(task.getEndTimeExcepted().after(date)) {
						todos.add(task);
					}
				}
			}
		}
		return todos;
	}

	@Override
	public List<TaskVo> getPresentTasks() {
		List<TaskVo> presentTasks = new ArrayList<>();
		//获取所有任务，将符合条件的任务添加进presentTasks
		List<TaskVo> allTasks = taskDao.getAllTasks();
		Date date = new Date();
		for(TaskVo task : allTasks) {
			if(task.getIsDelete() != 1 && task.getIsComplete() !=1){
				if(task.getBeginTimeActual() != null 
						&& date.before(task.getEndTimeExcepted())) {
					presentTasks.add(task);
				}
			}
		}
		
		return presentTasks;
	}

	@Override
	public List<TaskVo> getTasksByPriority(Enum priority) {
		List<TaskVo> taskList = new ArrayList<>();
		//获取所有任务，将符合条件的任务添加进taskList
		List<TaskVo> allTasks = taskDao.getAllTasks();
		for(TaskVo task : allTasks) {
			if(task.getIsDelete() != 1 && task.getIsComplete() !=1){
				if(priority.equals(task.getPriority())) {
					taskList.add(task);
				}
			}
		}
		
		return taskList;
	}

	@Override
	public List<TaskVo> getOverdueTasks() {
		List<TaskVo> overdueTasks = new ArrayList<>();
		//获取所有任务，将符合条件的任务添加进overdueTasks
		List<TaskVo> allTasks = taskDao.getAllTasks();
		Date date = new Date();
		for(TaskVo task : allTasks) {
			if(task.getIsDelete() != 1){
				if(task.getBeginTimeActual() == null 
						&& task.getEndTimeExcepted().before(date)) {
					overdueTasks.add(task);
				}else if (task.getBeginTimeActual() != null ){
					if(task.getIsComplete() ==1 && task.getEndTimeActual().after(task.getEndTimeExcepted())){
						overdueTasks.add(task);
					}else if(task.getIsComplete() ==0 && date.after(task.getEndTimeExcepted())){
						overdueTasks.add(task);
					}
					
				}
			}
		}
		
		return overdueTasks;
	}
	
	
	


	@Override
	public void insertTask(TaskVo taskVo) {
		taskDao.insertTask(taskVo);
	}

	@Override
	public void updateTask(TaskVo taskVo) {
		taskDao.updateTask(taskVo);
	}

	@Override
	public void deleteTask(Integer id) {
		taskDao.deleteTask(id);
	}

	@Override
	public List<TaskVo> getCompletedTasks() {
		List<TaskVo> completedTasks = new ArrayList<>();
		
		List<TaskVo> allTasks = taskDao.getAllTasks();
		for(TaskVo task : allTasks) {
			if(task.getIsComplete() == 1) {
				completedTasks.add(task);
			}
		}
		
		return completedTasks;
	}

	@Override
	public double getPercentOfCompletedTasks() {
		Double percentOfCompletedTasks = new Double(0);
		List<TaskVo> completedTasks=this.getCompletedTasks();
		List<TaskVo> allTasks = taskDao.getAllTasks();
		if(allTasks.size() !=0){
			percentOfCompletedTasks = (double) (completedTasks.size()/allTasks.size());
		}
		
		return percentOfCompletedTasks;
	}
	
}
