package cn.sun.tasks.timeactual.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sun.tasks.timeactual.dao.TimeActualDao;
import cn.sun.tasks.timeactual.domain.TimeActual;

@Service
public class TimeActualServiceBizImpl implements TimeActualService {
	
	@Autowired
	private TimeActualDao timeActualDao;

	@Override
	public void insertTimeActual(TimeActual timeActual) {
		timeActualDao.insertTimeActual(timeActual);
	}

	@Override
	public void updatetTimeActual(TimeActual timeActual) {
		timeActualDao.updatetTimeActual(timeActual);
	}

	@Override
	public void deleteTimeActualById(Integer id) {
		timeActualDao.deleteTimeActualByid(id);
	}
	
	

}
