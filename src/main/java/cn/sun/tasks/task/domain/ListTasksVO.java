package cn.sun.tasks.task.domain;

import java.util.Date;
import java.util.List;

import cn.sun.tasks.timeactual.domain.TimeActual;
import cn.sun.tasks.timeexpected.domain.TimeExpected;

public class ListTasksVO {
	private Integer pageNo;
	private Integer pageSize;
	private Integer id;
	private String content;
	private String desc;
	private Byte priority;
	private Byte isHabit;
	private Byte isComplete;
	private Date createTime;
	private Date updateTime;
	private Date deleteTime;
	private Byte isDelete;
	private List<TimeExpected> timeExpecteds;
	private List<TimeActual> timeActuals;
	public Integer getPageNo() {
		return pageNo;
	}
	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
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
	public Byte getPriority() {
		return priority;
	}
	public void setPriority(Byte priority) {
		this.priority = priority;
	}
	public Byte getIsHabit() {
		return isHabit;
	}
	public void setIsHabit(Byte isHabit) {
		this.isHabit = isHabit;
	}
	public Byte getIsComplete() {
		return isComplete;
	}
	public void setIsComplete(Byte isComplete) {
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
	public Byte getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(Byte isDelete) {
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
