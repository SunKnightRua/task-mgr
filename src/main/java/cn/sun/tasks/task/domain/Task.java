package cn.sun.tasks.task.domain;

import java.util.Date;
import java.util.List;

import cn.sun.tasks.timeactual.domain.TimeActual;
import cn.sun.tasks.timeexpected.domain.TimeExpected;

public class Task {
	
	private int id;
	private String content;
	private String desc;
	private byte priority;
	private byte isHabit;
	private byte isComplete;
	private Date createTime;
	private Date updateTime;
	private Date deleteTime;
	private byte isDelete;
	private List<TimeExpected> timeExpecteds;
	private List<TimeActual> timeActuals;
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
	public byte getIsHabit() {
		return isHabit;
	}
	public void setIsHabit(byte isHabit) {
		this.isHabit = isHabit;
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
	public List<TimeExpected> getTimeExpecteds() {
		return timeExpecteds;
	}
	public void setTimeExpecteds(List<TimeExpected> timeExpecteds) {
		this.timeExpecteds = timeExpecteds;
	}
	public List<TimeActual> getTimeActuals() {
		return timeActuals;
	}
	public void setTimeActuals(List<TimeActual> timeActuals) {
		this.timeActuals = timeActuals;
	}
}
