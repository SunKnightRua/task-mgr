package cn.sun.tasks.task.domain;

import java.util.Date;

public class Task {
	
	private int id;
	private String content;
	private String desc;
	private byte priority;
	private byte isHabbit;
	private byte isComplete;
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
