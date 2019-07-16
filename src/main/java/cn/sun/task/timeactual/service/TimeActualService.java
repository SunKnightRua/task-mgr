package cn.sun.task.timeactual.service;

import cn.sun.task.timeactual.domain.TimeActual;

public interface TimeActualService {

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
