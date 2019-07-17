package cn.sun.tasks.timeexpected.service;

import java.util.List;

import cn.sun.tasks.timeexpected.domain.TimeExpected;

public interface TimeExpectedService {

	/**
	 * 获取冲突任务
	 */
	public abstract List<Integer> getConflictTaskIds();
	
	/**
	 * 插入期望时间
	 * @param timeExpected 期望时间
	 */
	public void insertTimeExpected(TimeExpected timeExpected);
	
	/**
	 * 更新期望时间
	 * @param timeExpected 期望时间
	 */
	public void updatetTimeExpected(TimeExpected timeExpected);
	
	
	/**
	 * 根据id删除期望时间
	 * @param Id 
	 */
	public void deleteTimeExpectedById(Integer Id);
}
