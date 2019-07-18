package cn.sun.tasks.task.vo;

import java.util.Date;

public class TaskVo {

	private int id;
	private String content;
	private String desc;
	private byte priority;
	private byte isHabbit;
	private byte isComplete;
	private Date beginTimeExpected;
	private Date endTimeExcepted;
	private Date beginTimeActual;
	private Date endTimeActual;
	private Date createTime;
	private Date updateTime;
	private Date deleteTime;
	private byte isDelete;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public byte getPriority() {
		return priority;
	}
	public void setPriority(byte priority) {
		this.priority = priority;
	}
	public byte getIsHabbit() {
		return isHabbit;
	}
	public void setIsHabbit(byte isHabbit) {
		this.isHabbit = isHabbit;
	}
	public byte getIsComplete() {
		return isComplete;
	}
	public void setIsComplete(byte isComplete) {
		this.isComplete = isComplete;
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
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public Date getDeleteTime() {
		return deleteTime;
	}
	public void setDeleteTime(Date deleteTime) {
		this.deleteTime = deleteTime;
	}
	public byte getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(byte isDelete) {
		this.isDelete = isDelete;
	}
	
}
