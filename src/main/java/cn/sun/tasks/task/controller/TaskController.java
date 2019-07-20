package cn.sun.tasks.task.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.sun.tasks.task.domain.Task;
import cn.sun.tasks.task.service.TaskService;

@Controller
@RequestMapping("/task")
public class TaskController {

	@Autowired
	private TaskService taskService;
	
	@RequestMapping("/getAllTasks")
	public String getAllTasks(Model model) {
		List<Task> allTasks = taskService.getAllTasks();
		List<Task> tasks = new ArrayList<Task>();
		for(Task task : allTasks){
			if (task.getIsDelete() == 0){
				tasks.add(task);
			}
		}
		model.addAttribute("tasks",tasks);
		return "getAllTasks.vm";
	}
	
	@RequestMapping("/getTaskById")
	public String getTaskById(Model model ,Integer id) {
		Task task= taskService.getTaskById(id);
		model.addAttribute("task", task);
		return "getTaskById.vm";	
	}
	
	@RequestMapping("/getTaskByIds")
	public Model getTaskByIds(Model model, List<Integer> ids) {
		List<Task> tasks = taskService.getTaskByIds(ids);
		model.addAttribute("tasks",tasks);
		return model;	
	}
	
	@RequestMapping("/insertTask")
	public String insertTask(Task task) {
		taskService.insertTask(task);
		return "redirect:getAllTasks.vm";
	}
	
	@RequestMapping("/updateTask")
	public String updateTask(Task task) {
		taskService.updateTask(task);
		return "redirect:getAllTasks.vm";
	}
	
	@RequestMapping("/deleteTask")
	public String deleteTask(Integer id) {
		taskService.deleteTask(id);
		return "redirect:getAllTasks.vm";
	}
	
	@RequestMapping("/getCompletedTasks")
	public Model getCompletedTasks(Model model) {
		List<Task> completedTasks = taskService.getCompletedTasks();
		model.addAttribute("completedTasks",completedTasks);
		return model;
	}
	
	@RequestMapping("/getOverdueTasks")
	public Model getOverdueTasks(Model model){
		List<Task> overdueTasks =taskService.getOverdueTasks();
		model.addAttribute("overdueTasks",overdueTasks);
		return model;
	}
	
	@RequestMapping("/getTodos")
	public Model getTodos(Model model) {
		 List<Task> todos =taskService.getTodos();
		 model.addAttribute("todos",todos);
		return model;
	}
	
	@RequestMapping("/getPresentTasks")
	public Model getPresentTasks(Model model) {
		 List<Task> presentTasks =taskService.getPresentTasks();
		 model.addAttribute("presentTasks",presentTasks);
		return model;
	}
	
	@RequestMapping("/getTasksByPriority")
	public Model getTasksByPriority(Model model,Integer priority) {
		 List<Task> tasks = taskService.getTasksByPriority(priority);
		 model.addAttribute("tasks",tasks);
		return model;
	}
	
	@RequestMapping("getPercentOfCompletedTasks")
	public Double getPercentOfCompletedTasks(){
		return taskService.getPercentOfCompletedTasks();
	}
}
