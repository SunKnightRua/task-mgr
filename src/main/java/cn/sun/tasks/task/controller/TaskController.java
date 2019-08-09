package cn.sun.tasks.task.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cn.sun.tasks.task.domain.Task;
import cn.sun.tasks.task.service.TaskService;
import cn.sun.tasks.timeactual.domain.TimeActual;
import cn.sun.tasks.timeexpected.domain.TimeExpected;

/**
 * TaskController
 * 
 * @author Sun
 *
 */
@Controller
@RequestMapping("/task")
public class TaskController {

	@Autowired
	private TaskService taskService;

	/**
	 * 分页获取任务
	 * 
	 * @param model
	 * @return 获取所有任务
	 */
	@RequestMapping("/getAllTasks")
	public String getAllTasks(Model model, @RequestParam("pageNo") int pageNo, @RequestParam("pageSize") int pageSize,
			@RequestParam("content") String content, @RequestParam("desc") String desc,
			@RequestParam("priority") Byte priority, @RequestParam("isHabit") Byte isHabit,
			@RequestParam("isComplete") Byte isComplete) {
		//对中文参数进行解码
		try {
			content =new String(content.getBytes("ISO8859-1"),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		try {
			desc=new String(desc.getBytes("ISO8859-1"),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		model.addAttribute("pageNo", pageNo);
		model.addAttribute("searTabContent", content);
		model.addAttribute("searTabDesc", desc);
		model.addAttribute("searTabPriority", priority);
		model.addAttribute("searTabIsHabit", isHabit);
		model.addAttribute("searTabIsComplete", isComplete);
		List<Task> allTasks = taskService.getAllTasks(pageNo, pageSize, content, desc, priority, isHabit, isComplete);
		List<Task> tasks = new ArrayList<Task>();
		for (Task task : allTasks) {
			tasks.add(task);
		}
		model.addAttribute("tasks", tasks);
		int totalCount = taskService.getAllTasksTotalCount(content, desc, priority, isHabit, isComplete);
		model.addAttribute("totalCount", totalCount);
		return "taskList.vm";
	}

	/**
	 * 根据id查询任务
	 * 
	 * @param model
	 * @param id
	 *            任务id
	 * @return 对应的任务
	 */
	@RequestMapping("/getTaskById")
	public String getTaskById(Model model, Integer id) {
		List<Task> tasks = new ArrayList<Task>();
		Task task = taskService.getTaskById(id);
		tasks.add(task);
		model.addAttribute("tasks", tasks);
		return "taskList.vm";
	}

	// @RequestMapping("/getTaskByIds")
	// public String getTaskByIds(Model model, List<Integer> ids) {
	// List<Task> tasks = taskService.getTaskByIds(ids);
	// model.addAttribute("tasks", tasks);
	// return "taskList.vm";
	// }

	/**
	 * 新增任务
	 * 
	 * @return 新增任务页面
	 */

	@RequestMapping(value = "/addTask", method = RequestMethod.GET)
	public String addTask() {
		return "addTask.vm";
	}

	@RequestMapping(value = "/addTask", method = RequestMethod.POST)
	public String addTask(@RequestParam(value = "content", required = true) String content,
			@RequestParam(value = "desc") String desc, @RequestParam(value = "priority") byte priority,
			@RequestParam(value = "isHabit") byte isHabit,
			@RequestParam(value = "beginTimeExpected") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm") Date beginTimeExpected,
			@RequestParam(value = "endTimeExpected") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm") Date endTimeExpected,
			@RequestParam(value = "beginTimeActual") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm") Date beginTimeActual,
			@RequestParam(value = "endTimeActual") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm") Date endTimeActual,
			@RequestParam(value = "isComplete") byte isComplete) {
		List<TimeExpected> timeExpecteds = new ArrayList<TimeExpected>();
		List<TimeActual> timeActuals = new ArrayList<TimeActual>();
		// 设置timeExpecteds,如果beginTimeExpected和endTimeExpected都为null,则不添加进timeExpecteds
		TimeExpected timeExpected = new TimeExpected();
		timeExpected.setBeginTimeExpected(beginTimeExpected);
		timeExpected.setEndTimeExpected(endTimeExpected);
		if (timeExpected.getBeginTimeExpected() != null || timeExpected.getEndTimeExpected() != null) {
			timeExpecteds.add(timeExpected);
		}
		// 设置timeActuals,如果beginTimeActual和endTimeActual都为null,则不添加进timeActuals
		TimeActual timeActual = new TimeActual();
		timeActual.setBeginTimeActual(beginTimeActual);
		timeActual.setEndTimeActual(endTimeActual);
		if (timeActual.getBeginTimeActual() != null || timeActual.getEndTimeActual() != null) {
			timeActuals.add(timeActual);
		}
		Task task = new Task();
		task.setContent(content);
		task.setDesc(desc);
		task.setPriority(priority);
		task.setIsHabit(isHabit);
		task.setTimeExpecteds(timeExpecteds);
		task.setTimeActuals(timeActuals);
		task.setIsComplete(isComplete);
		taskService.addTask(task);
		return "redirect:/task/getAllTasks";
	}

	// 待修改
	/**
	 * 更新任务
	 * 
	 * @param task
	 * @return
	 */
	@RequestMapping("/updateTask")
	public String updateTask(Task task) {
		// taskService.updateTask(task);
		return "getAllTasks.vm";
	}

	/**
	 * 删除任务
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("/deleteTask")
	public String deleteTask(Integer id) {
		// taskService.deleteTask(id);
		return "redirect:getAllTasks";
	}

	/**
	 * 查询已完成任务
	 * 
	 * @param model
	 * @return 已完成任务
	 */
	@RequestMapping("/getCompletedTasks")
	public String getCompletedTasks(Model model, @Param("pageNo") Integer pageNo, @Param("pageSize") Integer pageSize) {
		List<Task> tasks = taskService.getCompletedTasks(pageNo, pageSize);
		model.addAttribute("tasks", tasks);
		return "taskList.vm";
	}

	/**
	 * 逾期任务
	 * 
	 * @param model
	 * @return 逾期任务
	 */
	@RequestMapping("/getOverdueTasks")
	public String getOverdueTasks(Model model) {
		// List<Task> tasks = taskService.getOverdueTasks();
		// model.addAttribute("tasks", tasks);
		return "taskList.vm";
	}

	/**
	 * 待办任务
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/getTodos")
	public String getTodos(Model model) {
		// List<Task> tasks = taskService.getTodos();
		// model.addAttribute("tasks", tasks);
		return "taskList.vm";
	}

//	/**
//	 * 当前任务
//	 * 
//	 * @param model
//	 * @return
//	 */
//	@RequestMapping("/getPresentTasks")
//	public String getPresentTasks(Model model) {
//		// List<Task> tasks = taskService.getPresentTasks();
//		// model.addAttribute("tasks", tasks);
//		return "taskList.vm";
//	}

	/**
	 * 任务完成度
	 * 
	 * @return
	 * @throws IOException
	 */
	// @RequestMapping(value="/getPercentOfCompletedTasks",
	// method=RequestMethod.POST)
	// public void getPercentOfCompletedTasks(HttpServletResponse response)
	// throws IOException {
	// String jsonStr ="" + taskService.getPercentOfCompletedTasks();
	// response.getWriter().write(jsonStr);;
	// }
}
