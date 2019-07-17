package cn.sun.tasks.timeactual.domain;

import java.util.Date;

public class TimeActual {

	private int id;
	private int taskId;
	private Date beginTimeActual;
	private Date endTimeActual;
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
	public Date getBeginTimeActual() {
		return beginTimeActual;
	}
	public void setBeginTimeActual(Date beginTimeActual) {
		this.beginTimeActual = beginTimeActual;
	}
	public Date getEndTimeActual() {
		return endTimeActual;
	}
	public void setEndTimeActual(Date endTimeActual) {
		this.endTimeActual = endTimeActual;
	}
	
	
}
