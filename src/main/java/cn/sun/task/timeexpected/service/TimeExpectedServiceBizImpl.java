package cn.sun.task.timeexpected.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sun.task.timeexpected.dao.TimeExpectedDao;
import cn.sun.task.timeexpected.domain.TimeExpected;

@Service
public class TimeExpectedServiceBizImpl implements TimeExpectedService {

	@Autowired
	private TimeExpectedDao timeExpectedDao;
	
	@Override
	public List<Integer> getConflictTaskIds() {

		List<Integer> conflictingTaskIds = new ArrayList<Integer>();
		
		 List<TimeExpected> timeExpecteds =timeExpectedDao.selectAll();
		 
		for(int i=0; i<timeExpecteds.size(); i++){
			for(int j=i+1; j<timeExpecteds.size(); j++){
				if(timeExpecteds.get(i).getBeginTimeExpected().after(timeExpecteds.get(j).getBeginTimeExpected()) 
						&& timeExpecteds.get(i).getBeginTimeExpected().before(timeExpecteds.get(j).getEndTimeExcepted())) {
					//条件成立则冲突，获取此任务添加至conflictingTasks中
					conflictingTaskIds.add(timeExpecteds.get(i).getTaskId());
				}else if(timeExpecteds.get(i).getEndTimeExcepted().after(timeExpecteds.get(j).getBeginTimeExpected())
						 && timeExpecteds.get(i).getEndTimeExcepted().before(timeExpecteds.get(j).getEndTimeExcepted())) {
					//条件成立则冲突，获取此任务添加至conflictingTasks中
					conflictingTaskIds.add(timeExpecteds.get(i).getTaskId());
				}
			}
		}
		
		return conflictingTaskIds;
	}

	@Override
	public void insertTimeExpected(TimeExpected timeExpected) {
		timeExpectedDao.insertTimeExpected(timeExpected);
	}

	@Override
	public void updatetTimeExpected(TimeExpected timeExpected) {
		timeExpectedDao.updatetTimeExpected(timeExpected);
	}

	@Override
	public void deleteTimeExpectedById(Integer Id) {
		timeExpectedDao.deleteTimeExpectedById(Id);
	}
	
	
	
	
}
