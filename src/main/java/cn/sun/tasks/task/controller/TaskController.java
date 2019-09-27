package cn.sun.tasks.task.controller;

import java.io.UnsupportedEncodingException;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.sun.tasks.common.page.Page;
import cn.sun.tasks.task.domain.Msg;
import cn.sun.tasks.task.domain.Task;
import cn.sun.tasks.task.service.TaskService;

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

	@RequestMapping(value = "/listTasks", method = RequestMethod.GET)
	public String listTasks() {
		return "taskList.vm";
	}

	/**
	 * 分页获取任务
	 */
	@RequestMapping("/listTasks")
	@ResponseBody
	public Object listTasks(Integer pageNo, Integer pageSize, String content, 
			String desc, Byte priority, Byte isHabit, Byte isComplete) {
		// 对中文参数进行解码
		try {
			content = new String(content.getBytes("ISO8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		try {
			desc = new String(desc.getBytes("ISO8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		Page<Task> page = taskService.listTasks(pageNo, pageSize, content, desc, priority, isHabit, isComplete);

		// 返回值为Msg
		return Msg.success().add("page", page).add("searTabContent", content).add("searTabDesc", desc)
				.add("searTabPriority", priority).add("searTabIsHabit", isHabit).add("searTabIsComplete", isComplete);
	}

	/**
	 * 根据id查询任务
	 * 
	 * @param model
	 * @param id
	 *            任务id
	 * @return 对应的任务
	 */
	@RequestMapping("/getTask")
	@ResponseBody
	public Msg getTaskById(Integer id) {
		Task task = taskService.getTaskById(id);
		return Msg.success().add("task", task);
	}

	/**
	 * 新增任务
	 * 
	 * @return 新增任务页面
	 */
	@RequestMapping(value = "/addTask", method = RequestMethod.POST)
	@ResponseBody
	public Msg addTask(@RequestBody Task task) {
		taskService.addTask(task);
		return Msg.success();
	}

	// 待修改
	/**
	 * o 更新任务
	 * 
	 * @param task
	 * @return
	 */
	@RequestMapping("/updateTask")
	@ResponseBody
	public Msg updateTask(@RequestBody Task task) {
		taskService.updateTask(task);
		return Msg.success();
	}

	/**
	 * 删除任务
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/deleteTask", method = RequestMethod.POST)
	@ResponseBody
	public Msg deleteTask(Integer id) {
		taskService.deleteTask(id);
		return Msg.success();
	}
	//
	// /**
	// * 查询已完成任务
	// *
	// * @param model
	// * @return 已完成任务
	// */
	// @RequestMapping("/getCompletedTasks")
	// public String getCompletedTasks(Model model, @Param("pageNo") Integer
	// pageNo, @Param("pageSize") Integer pageSize) {
	// List<Task> tasks = taskService.getCompletedTasks(pageNo, pageSize);
	// model.addAttribute("tasks", tasks);
	// int totalCount = taskService.getCompletedTasksTotalCount();
	// model.addAttribute("totalCount", totalCount);
	// model.addAttribute("pageNo", pageNo);
	// return "taskList.vm";
	// }
	//
	// /**
	// * 逾期任务
	// *
	// * @param model
	// * @return 逾期任务
	// */
	// @RequestMapping("/getOverdueTasks")
	// public String getOverdueTasks(Model model, @Param("pageNo") Integer
	// pageNo, @Param("pageSize") Integer pageSize) {
	// List<Task> tasks = taskService.getOverdueTasks(pageNo, pageSize);
	// model.addAttribute("tasks", tasks);
	// int totalCount = taskService.getOverdueTasksTotalCount();
	// model.addAttribute("totalCount", totalCount);
	// model.addAttribute("pageNo", pageNo);
	// return "taskList.vm";
	// }
	//
	// /**
	// * 待办任务
	// *
	// * @param model
	// * @return
	// */
	// @RequestMapping("/getTodos")
	// public String getTodos(Model model, @Param("pageNo") Integer pageNo,
	// @Param("pageSize") Integer pageSize) {
	// List<Task> tasks = taskService.getTodos(pageNo, pageSize);
	// model.addAttribute("tasks", tasks);
	// int totalCount = taskService.getTodosTotalCount();
	// model.addAttribute("totalCount", totalCount);
	// model.addAttribute("pageNo", pageNo);
	// return "taskList.vm";
	// }
	//
	// /**
	// * 当前任务
	// *
	// * @param model
	// * @return
	// */
	// @RequestMapping("/getPresentTasks")
	// public String getPresentTasks(Model model, @Param("pageNo") Integer
	// pageNo, @Param("pageSize") Integer pageSize) {
	// List<Task> tasks = taskService.getPresentTasks(pageNo, pageSize);
	// model.addAttribute("tasks", tasks);
	// int totalCount = taskService.getPresentTasksTotalCount();
	// model.addAttribute("totalCount", totalCount);
	// model.addAttribute("pageNo", pageNo);
	// return "taskList.vm";
	// }
	//
	// /**
	// * 任务完成度
	// *
	// * @return
	// * @throws IOException
	// */
	// @RequestMapping(value="/getPercentOfCompletedTasks",
	// method=RequestMethod.POST)
	// public void getPercentOfCompletedTasks(HttpServletResponse response)
	// throws IOException {
	// String jsonStr ="" + taskService.getPercentOfCompletedTasks();
	// response.getWriter().write(jsonStr);;
	// }
}
