package cn.sun.tasks.timeactual.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sun.tasks.timeactual.dao.TimeActualDao;
import cn.sun.tasks.timeactual.domain.TimeActual;

@Service
public class TimeActualServiceBizImpl implements TimeActualService {
	
	@Autowired
	private TimeActualDao timeActualDao;

	@Override
	public List<TimeActual> selectAll() {
		List<TimeActual> timeActualList =timeActualDao.selectAll();
		return timeActualList;
	}

	@Override
	public void insertTimeActual(TimeActual timeActual) {
		timeActualDao.addTimeActual(timeActual);
	}

	@Override
	public void updatetTimeActual(TimeActual timeActual) {
		timeActualDao.updateTimeActual(timeActual);
	}

	@Override
	public void deleteTimeActualById(Integer id) {
		timeActualDao.deleteTimeActualByid(id);
	}

	
	

}
