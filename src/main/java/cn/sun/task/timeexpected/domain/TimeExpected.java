package cn.sun.task.timeexpected.domain;

import java.util.Date;

public class TimeExpected {
//	t_time_expected
//	id
//	task_id
//	begin_time_expected
//	end_time_expected

	
	private int id;
	private int taskId;
	private Date beginTimeExpected;
	private Date endTimeExcepted;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTaskId() {
		return taskId;
	}
	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}
	public Date getBeginTimeExpected() {
		return beginTimeExpected;
	}
	public void setBeginTimeExpected(Date beginTimeExpected) {
		this.beginTimeExpected = beginTimeExpected;
	}
	public Date getEndTimeExcepted() {
		return endTimeExcepted;
	}
	public void setEndTimeExcepted(Date endTimeExcepted) {
		this.endTimeExcepted = endTimeExcepted;
	}
	
	
}
