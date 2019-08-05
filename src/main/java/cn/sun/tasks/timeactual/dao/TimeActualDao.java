package cn.sun.tasks.timeactual.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.sun.tasks.timeactual.domain.TimeActual;

@Repository
public interface TimeActualDao {

	public List<TimeActual> selectAll();
	
	public void addTimeActual(TimeActual timeActual);
	public void updateTimeActual(TimeActual timeActual);
	public void deleteTimeActualByid(Integer id);
	
	/**
	 * 根据任务id查询实际时间
	 * @param id任务id
	 * @return 该任务的实际时间的list
	 */
	public List<TimeActual> getTimeActualsByTaskId(int id);
}
