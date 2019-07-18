package cn.sun.tasks.timeactual.service;

import java.util.List;

import cn.sun.tasks.timeactual.domain.TimeActual;

public interface TimeActualService {
	
	/**
	 * 查找所有实际时间
	 * @return 所有实际时间
	 */
	public List<TimeActual> selectAll();

	/**
	 * 插入实际时间
	 * @param timeActual 实际时间
	 */
	public void insertTimeActual(TimeActual timeActual);
	
	/**
	 * 更新实际时间
	 * @param timeActual 实际时间
	 */
	public void updatetTimeActual(TimeActual timeActual);
	
	/**
	 * 根据id删除实际时间
	 * @param id
	 */
	public void deleteTimeActualById(Integer id);
}
