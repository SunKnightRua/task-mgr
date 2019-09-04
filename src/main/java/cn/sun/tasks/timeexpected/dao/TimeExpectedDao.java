package cn.sun.tasks.timeexpected.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.sun.tasks.timeexpected.domain.TimeExpected;

@Repository
public interface TimeExpectedDao {
	
	public List<TimeExpected> selectAll();
	
	public void addTimeExpected(TimeExpected timeExpected);
	public void updateTimeExpected(TimeExpected timeExpected);
	public void deleteTimeExpectedByTaskId(Integer taskId);
	
	/**
	 * 根据任务id查询预期时间
	 * @param id 任务id
	 * @return 该任务的预期时间的list
	 */
	public List<TimeExpected> getTimeExpectedsByTaskId(int id);
}
