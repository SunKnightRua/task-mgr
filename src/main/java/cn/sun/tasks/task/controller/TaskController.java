package cn.sun.tasks.task.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.sun.tasks.task.domain.Task;
import cn.sun.tasks.task.service.TaskService;

@Controller
@RequestMapping("/task")
public class TaskController {

	@Autowired
	private TaskService taskService;
	
	@RequestMapping("/getAllTasks")
	public Model getAllTasks(Model model) {
		List<Task> tasks = taskService.getAllTasks();
			model.addAttribute("tasks",tasks);
		return model;
	}
}
