package cn.sun.tasks.task.domain;

import java.util.Date;

public class Task {
	
	private int id;
	private String content;
	private String desc;
	private byte priority;
	private byte is_habbit;
	private byte is_complete;
	private Date create_time;
	private Date update_time;
	private Date delete_time;
	private byte is_delete;
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
	public byte getIs_habbit() {
		return is_habbit;
	}
	public void setIs_habbit(byte is_habbit) {
		this.is_habbit = is_habbit;
	}
	public byte getIs_complete() {
		return is_complete;
	}
	public void setIs_complete(byte is_complete) {
		this.is_complete = is_complete;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public Date getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}
	public Date getDelete_time() {
		return delete_time;
	}
	public void setDelete_time(Date delete_time) {
		this.delete_time = delete_time;
	}
	public byte getIs_delete() {
		return is_delete;
	}
	public void setIs_delete(byte is_delete) {
		this.is_delete = is_delete;
	}
	
	
	
}
