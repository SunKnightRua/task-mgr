package cn.sun.tasks.task.service;

import java.util.List;

import cn.sun.tasks.task.domain.Task;

public interface TaskService {

	/**
	 * 鏌ヨ鎵�湁浠诲姟
	 * @return 浠婃棩鎵�湁浠诲姟
	 */
	public abstract List<Task> getAllTasks();
	
	/**
	 * 鏍规嵁id鏌ヨ浠诲姟
	 * @param id 浼犲叆鐨勪换鍔d
	 * @return 浼犲叆id瀵瑰簲鐨勪换鍔�
	 */
	public abstract Task getTaskById(Integer id);
	
	/**
	 * 鏍规嵁浼犲叆鐨刬d闆嗗悎鏌ヨ浠诲姟
	 * @param list 绗﹀悎鏉′欢鐨勪换鍔d闆嗗悎
	 * @return 绗﹀悎鏉′欢鐨勪换鍔�
	 */
	public List<Task> getTaskById(List<Integer> list);
	
	/**
	 * 鏂板涓�潯浠诲姟
	 * @param task 浠诲姟淇℃伅
	 */
	public void insertTask(Task task);
	
	/**
	 * 鏇存柊浠诲姟
	 * @param task 浠诲姟淇℃伅
	 */
	public void updateTask(Task task);
	
	/**
	 * 鍒犻櫎浠诲姟
	 * @param id 浠诲姟id
	 */
	public void deleteTask(Integer id);
	
	/**
	 * 鏌ヨ宸插畬鎴愪换鍔�
	 * @return 宸插畬鎴愪换鍔�
	 */
	public List<Task> getCompletedTasks();
	
	/**
	 * 鑾峰彇閫炬湡浠诲姟
	 * @return 閫炬湡浠诲姟
	 */
	public List<Task> getOverdueTasks();
	
	/**
	 * 鏌ユ壘寰呭姙浠诲姟
	 * @return 寰呭姙浠诲姟
	 */
	public List<Task> getTodos();
	
	/**
	 * 鏌ユ壘褰撳墠浠诲姟
	 * @return 褰撳墠浠诲姟
	 */
	public List<Task> getPresentTasks();
	
	/**
	 * 鏍规嵁浼樺厛绾ф煡鎵句换鍔�
	 * @param priority 浼樺厛绾�
	 * @return 瀵瑰簲浼樺厛绾х殑浠诲姟
	 */
	public List<Task> getTasksByPriority(Enum priority);
	
	

//	6.	浠诲姟瀹屾垚姣斾緥
	//鏄笉鏄笉搴旇鍦ㄨ繖閲岃绠�

}
