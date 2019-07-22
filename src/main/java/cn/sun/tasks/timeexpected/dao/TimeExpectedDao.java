package cn.sun.tasks.timeexpected.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.sun.tasks.timeexpected.domain.TimeExpected;

@Repository
public interface TimeExpectedDao {
	
	public List<TimeExpected> selectAll();
	
	public void insertTimeExpected(TimeExpected timeExpected);
	public void updatetTimeExpected(TimeExpected timeExpected);
	public void deleteTimeExpectedByTaskId(Integer taskId);
}
