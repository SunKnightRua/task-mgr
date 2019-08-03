package cn.sun.tasks.timeexpected.domain;

import java.util.Date;

public class TimeExpected {

	private int id;
	private int taskId;
	private Date beginTimeExpected;
	private Date endTimeExpected;
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
	public Date getEndTimeExpected() {
		return endTimeExpected;
	}
	public void setEndTimeExpected(Date endTimeExpected) {
		this.endTimeExpected = endTimeExpected;
	}
	
}