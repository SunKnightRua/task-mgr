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

	// 获取所有未完成未删除任务
	@RequestMapping("/getAllTasks")
	public String getAllTasks(Model model) {
		List<Task> allTasks = taskService.getAllTasks();
		List<Task> tasks = new ArrayList<Task>();
		for (Task task : allTasks) {
			if (task.getIsDelete() == 0) {
				tasks.add(task);
			}
		}
		model.addAttribute("tasks", tasks);
		return "taskList.vm";
	}

	// 根据id查询任务
	@RequestMapping("/getTaskById")
	public String getTaskById(Model model, Integer id) {
		List<Task> tasks = new ArrayList<Task>();
		Task task = taskService.getTaskById(id);
		tasks.add(task);
		model.addAttribute("tasks", tasks);
		return "taskList.vm";
	}

	@RequestMapping("/getTaskByIds")
	public String getTaskByIds(Model model, List<Integer> ids) {
		List<Task> tasks = taskService.getTaskByIds(ids);
		model.addAttribute("tasks", tasks);
		return "taskList.vm";
	}

	// 新增任务
	@RequestMapping("/addTask")
	public String insertTask(Task task) {
		return "addTask.vm";
	}

	@RequestMapping("/saveInsert")
	public String saveInsert(Task task) {
		taskService.insertTask(task);
		return "redirect:getAllTasks";
	}

	// 待修改
	// 更新任务
	@RequestMapping("/updateTask")
	public String updateTask(Task task) {
		taskService.updateTask(task);
		return "redirect:getAllTasks";
	}

	// 删除任务
	@RequestMapping("/deleteTask")
	public String deleteTask(Integer id) {
		taskService.deleteTask(id);
		return "redirect:getAllTasks";
	}

	// 查询已完成任务
	@RequestMapping("/getCompletedTasks")
	public String getCompletedTasks(Model model) {
		List<Task> tasks = taskService.getCompletedTasks();
		model.addAttribute("tasks", tasks);
		return "taskList.vm";
	}

	// 逾期任务
	@RequestMapping("/getOverdueTasks")
	public String getOverdueTasks(Model model) {
		List<Task> tasks = taskService.getOverdueTasks();
		model.addAttribute("tasks", tasks);
		return "taskList.vm";
	}

	// 待办任务
	@RequestMapping("/getTodos")
	public String getTodos(Model model) {
		List<Task> tasks = taskService.getTodos();
		model.addAttribute("tasks", tasks);
		return "taskList.vm";
	}

	// 当前任务
	@RequestMapping("/getPresentTasks")
	public String getPresentTasks(Model model) {
		List<Task> tasks = taskService.getPresentTasks();
		model.addAttribute("tasks", tasks);
		return "taskList.vm";
	}

	// 根据优先级查询任务
	@RequestMapping("/getTasksByPriority")
	public String getTasksByPriority(Model model, Integer priority) {
		List<Task> tasks = taskService.getTasksByPriority(priority);
		model.addAttribute("tasks", tasks);
		return "taskList.vm";
	}
	

	//可以不用单独的方法，直接在页面上获取总任务数和已完成任务数，计算结果
	@RequestMapping("getPercentOfCompletedTasks")
	public Double getPercentOfCompletedTasks() {
		return taskService.getPercentOfCompletedTasks();
	}
}
