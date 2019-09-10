var URL_ADD_TASK = "/task-mgr/task/addTask";
var URL_LIST_TASKS = "/task-mgr/task/listTasks";
// 获取URL
var $url = location.href;
$url = $url.split("?", 1)[0];
var pages;
var content;
var desc;
var priority;
var isHabit;
var isComplete;
// 新增任务
var timeExpecteds = [];
var timeActuals = [];
// 编辑任务数据回显
var taskId;
var timeExpectedId;
var timeActualId;

var data;
// 页面加载
$(function() {
	// 查询任务
	listTasks(1);

	$("#add_save_btn").click(function() {
		// 添加任务
		addTask();
	});
	$("#task_update_btn").click(function() {
		// 更新任务提交
		updataTask();
	});
	//搜索方法
	$("#search_btn").click(function() {
		search();
	});
});

// 查询所有任务
function listTasks(pn) {
	data = {
		pageNo : pn,
		pageSize : 10,
		content : "",
		desc : "",
		priority : null,
		isHabit : null,
		isComplete : null
	};

	$.ajax({
		url : URL_LIST_TASKS,
		type : "POST",
		data : data,
		success : function(result) {
			console.log(result);
			build_task_table(result);
			build_page_info(result);
			build_page_nav(result);
		},
		error : function(e) {
			console.log(e.status);
			console.log(e.responseText);
		}
	});
};	
//构建任务表格
function build_task_table(result) {
	var tasks = result.extend.page.data;
	// 遍历结果
	$("#task_table tbody").empty();
	$.each(tasks, function(index, item) {
		var contentTd = $("<td></td>").append(item.content);
		var descTd = $("<td></td>").append(item.desc);
		var priorityTd = $("<td></td>").append(showPriority(item.priority));
		var isHabitTd = $("<td></td>").append(item.isHabit == 0 ? "否" : "是");
		var timeExpecteds = item.timeExpecteds;
		if(timeExpecteds.length == 0) {
			var timeExpectedsTd = $("<td></td>");
		}else {
			var timeExpectedsTd = $("<td></td>").append(showTimeExpecteds(timeExpecteds));
		}
		var timeActuals = item.timeActuals;
		if(timeActuals.length == 0) {
			var timeActualsTd = $("<td></td>");
		}else {
			var timeActualsTd = $("<td></td>").append(showTimeActuals(timeActuals));
		}
		var createTimeTd = $("<td></td>").append(showCreateAndUpdateTime(item.createTime));
		var updateTimeTd = $("<td></td>").append(showCreateAndUpdateTime(item.updateTime));
		var isCompleteTd = $("<td></td>").append(item.isComplete == 0 ? "否" : "是");
		var isDeleteTd = $("<td></td>").append(item.isDelete == 0 ? "否" : "是");
		var editBtn =$("<button></button>").addClass("btn btn-primary btn-sm edit_btn").append("编辑");
		editBtn.attr("task_id",item.id);
		var delBtn = $("<button></button>").addClass("btn btn-danger btn-sm del_btn").append("删除");
		delBtn.attr("task_id",item.id);
		var operationTd = $("<td></td>").append(editBtn).append(" ").append(delBtn);
		$("<tr></tr>").append(contentTd).append(descTd).append(priorityTd)
			.append(isHabitTd).append(timeExpectedsTd).append(timeActualsTd)
			.append(createTimeTd).append(updateTimeTd).append(isCompleteTd)
			.append(isDeleteTd).append(operationTd).appendTo("#task_table tbody");
	});
};
//构建分页信息
function build_page_info(result) {
	var pageInfo = result.extend.page;
	$("#page_info_area").empty();
	$("#page_info_area").append("<h3>当前" + pageInfo.pageNo + "页,总" 
		+ pageInfo.pages + "页,总" + pageInfo.totalNum + "条记录</h3>");
}
//构建分页导航条
function build_page_nav(result) {
	var pageInfo = result.extend.page;
	$("#page_nav_area").empty();
	var firstPage = $("<li></li>").append($("<a></a>").append("首页").attr("href","#"));
	var prePage = $("<li></li>").append($("<a></a>").append("&laquo;").attr("href","#"));
	var nextPage = $("<li></li>").append($("<a></a>").append("&raquo;").attr("href","#"));
	var lastPage = $("<li></li>").append($("<a></a>").append("末页").attr("href","#"));
	var ul = $("<ul></ul>").addClass("pagination").append(firstPage).append(prePage);
	
	var pre2Page = $("<li></li>").append($("<a></a>").append(pageInfo.pageNo - 2));
	var pre1Page = $("<li></li>").append($("<a></a>").append(pageInfo.pageNo - 1));
	var curPage = $("<li></li>").append($("<a></a>").append(pageInfo.pageNo)).addClass("active");
	var next1Page = $("<li></li>").append($("<a></a>").append(pageInfo.pageNo + 1));
	var next2Page = $("<li></li>").append($("<a></a>").append(pageInfo.pageNo + 2));
	ul.append(pre2Page).append(pre1Page).append(curPage).append(next1Page).append(next2Page);
	if(pageInfo.pageNo <= 1) {
		firstPage.remove();
		prePage.remove();
		pre2Page.remove();
		pre1Page.remove();
		ul.append(nextPage).append(lastPage);
	}else if(pageInfo.pageNo == 2) {
		pre2Page.remove();
		ul.append(lastPage);
	}else if(pageInfo.pageNo == pageInfo.pages - 1) {
		next2Page.remove();
		ul.append(lastPage);
	}else if(pageInfo.pageNo >= pageInfo.pages) {
		next1Page.remove();
		next2Page.remove();
		ul.append(nextPage).append(lastPage);
	};
	var nav = $("<nav></nav>").append(ul);
	$("#page_nav_area").append(nav);
	//绑定单击事件
	var pn = pageInfo.pageNo.valueOf();
	firstPage.click(function(){
		listTasks(1);
	});
	prePage.click(function(){
		listTasks(pn - 1);
	});
	pre2Page.click(function(){
		listTasks(pn - 2);
	});
	pre1Page.click(function(){
		listTasks(pn - 1);
	});
	next1Page.click(function(){
		listTasks(pn + 1);
	});
	next2Page.click(function(){
		listTasks(pn + 2);
	});
	nextPage.click(function(){
		listTasks(pn + 1);
	});
	lastPage.click(function(){
		listTasks(pageInfo.pages);
	});
}
//搜索方法
function search() {
	data = {
		content : $("#searTabContent").val(),
		desc : $("#searTabDesc").val(),
		priority : $("#searTabPriority").val(),
		isHabit : $("#searTabIsHabit").val(),
		isComplete : $("#searTabIsComplete").val()
	};
	$.ajax({
		url : URL_LIST_TASKS,
		type : "POST",
		data : data,
		success : function(result) {
			console.log(result);
			build_task_table(result);
			build_page_info(result);
			build_page_nav(result);
		},
		error : function(e) {
			console.log(e.status);
			console.log(e.responseText);
		}
	});
}
//对优先级的处理
function showPriority(priority) {
	switch (priority) {
	case 1:
		return "紧急</br>重要"
		break;
	case 2:
		return "紧急</br>不重要"
		break;
	case 3:
		return "不紧急</br>重要"
		break;
	case 4:
		return "不紧急</br>不重要"
	}
};
//对创建时间和更新时间的处理
function showCreateAndUpdateTime(datetime) {
	if(datetime != null) {
		var date = new Date(datetime);
		return date.getFullYear() + "-" + (date.getMonth() + 1) + "-" 
		+ date.getDate() + "<br/>" + date.getHours() + ":" + date.getMinutes() 
		+ ":" + date.getSeconds();
	}else {
		return null;
	}
}
//对预期时间的处理
function showTimeExpecteds(timeExpecteds) {
	var timeExpectedStr = "";
	$.each(timeExpecteds, function(index2, timeExpected) {
		if(timeExpected.beginTimeExpected != null) {
			timeExpectedStr += timeExpected.beginTimeExpected
				.substring(timeExpected.beginTimeExpected.indexOf(" "));
		}
		if(timeExpected.endTimeExpected != null) {
			timeExpectedStr += "-";
			timeExpectedStr += timeExpected.endTimeExpected
				.substring(timeExpected.endTimeExpected.indexOf(" "));
		}
	});
	return timeExpectedStr;
}
//对实际时间的处理
function showTimeActuals(timeActuals) {
	var timeActualStr = "";
	$.each(timeActuals, function(index3, timeActual) {
		if(timeActual.beginTimeActual != null) {
			timeActualStr += timeActual.beginTimeActual
				.substring(timeActual.beginTimeActual.indexOf(" "));
			timeActualStr += "-";
		}
		if(timeActual.endTimeActual != null) {
			timeActualStr += timeActual.endTimeActual
				.substring(timeActual.endTimeActual.indexOf(" "));
		}
	});
	return timeActualStr;
}
//编辑按钮绑定事件
$(document).on("click", ".edit_btn", function() {
	$.ajax({
		url : "/task-mgr/task/getTask?id=" + $(this).attr("task_id"),
		type : "GET",
		success : function(result) {
			build_edit_modal(result);
		},
		error:function(e){
			console.log(e.status);
			console.log(e.responseText);
		}
	});
});
// 更新任务回显
function build_edit_modal(result) {
	var task = result.extend.task;
	taskId = task.timeExpecteds[0].taskId;
	timeExpectedId = task.timeExpecteds[0].id;
	timeActualId = task.timeActuals[0].id;
	$("#edit_task_modal").modal('show');
	// 赋值
	$("#edit_content").val(task.content);
	$("#edit_desc").val(task.desc);
	$("#edit_priority").val(task.priority);
	$("#edit_isHabit").val(task.isHabit);
	if (task.timeExpecteds.length != 0) {
		$("#edit_beginTimeExpected").val(
				task.timeExpecteds[0].beginTimeExpected);
		$("#edit_endTimeExpected").val(
				task.timeExpecteds[0].endTimeExpected);
	} else {
		$("#edit_beginTimeExpected").val("");
		$("#edit_endTimeExpected").val("");
	}
	if (task.timeActuals.length != 0) {
		$("#edit_beginTimeActual").val(
				task.timeActuals[0].beginTimeActual);
		$("#edit_endTimeActual").val(
				task.timeActuals[0].endTimeActual);
	} else {
		$("#edit_beginTimeActual").val("");
		$("#edit_endTimeActual").val("");
	}
	$("#edit_isComplete").val(task.isComplete);

	console.log(result);
};
// 更新任务保存
function updataTask() {
	content = $("#edit_content").val();
	desc = $("#edit_desc").val();
	priority = $("#edit_priority").val();
	isHabit = $("#edit_isHabit").val();
	isComplete = $("#edit_isComplete").val();
	timeExpecteds = [ {
		"id" : timeExpectedId,
		"taskId" : taskId,
		"beginTimeExpected" : $("#edit_beginTimeExpected").val(),
		"endTimeExpected" : $("#edit_endTimeExpected").val()
	} ];
	timeActuals = [ {
		"id" : timeActualId,
		"taskId" : taskId,
		"beginTimeActual" : $("#edit_beginTimeActual").val(),
		"endTimeActual" : $("#edit_endTimeActual").val()
	} ];

	data = {
		"id" : taskId,
		"content" : content,
		"desc" : desc,
		"priority" : priority,
		"isHabit" : isHabit,
		"isComplete" : isComplete,
		"timeExpecteds" : timeExpecteds,
		"timeActuals" : timeActuals
	};
	$.ajax({
		url : "/task-mgr/task/updateTask",
		type : "POST",
		contentType : "application/json;charset=UTF-8",
		data : JSON.stringify(data),
		success : function(result) {
			alert("修改成功");
			window.location.reload();
		},
		error : function(e) {
			console.log(e.status);
			console.log(e.responseText);
		}
	});
};
//删除按钮绑定事件
$(document).on("click", ".del_btn", function() {
	$.ajax({
		url:"/task-mgr/task/deleteTask",
		type:"POST",
		data:{"id":$(this).attr("task_id")},
		success:function(result){
			if(result.code == 100) {
				alert("删除成功!");
				window.location.reload();
			}
		},
		error:function(e){
			console.log(e.status);
			console.log(e.responseText);
			alert("删除失败!");
		}
	});
});

// 添加任务保存
function addTask() {
	content = $("#add_content").val();
	desc = $("#add_desc").val();
	priority = $("#add_priority").val();
	isHabit = $("#add_isHabit").val();
	isComplete = $("#add_isComplete").val();
	timeExpecteds = [ {
		"beginTimeExpected" : $("#add_beginTimeExpected").val(),
		"endTimeExpected" : $("#add_endTimeExpected").val()
	} ];
	timeActuals = [ {
		"beginTimeActual" : $("#add_beginTimeActual").val(),
		"endTimeActual" : $("#add_endTimeActual").val()
	} ];
	data = {
		"content" : content,
		"desc" : desc,
		"priority" : priority,
		"isHabit" : isHabit,
		"timeExpecteds" : timeExpecteds,
		"timeActuals" : timeActuals,
		"isComplete" : isComplete
	};
	$.ajax({
		// 请求方式
		type : "POST",
		// 请求的媒体类型
		contentType : "application/json;charset=UTF-8",
		// 请求地址
		url : URL_ADD_TASK,
		// 数据，json字符串
		// data :data,
		data : JSON.stringify(data),
		// 请求成功
		success : function(result) {
			if (result.code == 100) {
				alert("插入成功");
			} else {
				alert(result.msg);
			}
			$("#add_task_modal").modal('hide');
		},
		// 请求失败，包含具体的错误信息
		error : function(e) {
			console.log(e.status);
			console.log(e.responseText);
			alert("插入失败");
		}
	});
};