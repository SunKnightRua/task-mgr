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
}
