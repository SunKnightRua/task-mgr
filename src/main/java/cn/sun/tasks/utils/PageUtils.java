package cn.sun.tasks.utils;

import java.util.ArrayList;
import java.util.List;
/**
 * 用于对查询结果进行假分页
 * @author Sun
 *
 */
public class PageUtils {
	//要分页的List结果的集合
	//private List<E> list;
	//查询结果总数
	//private Integer totalCount;
	//步长(每页显示的数量)
	//private Integer stepSize;
	//总页数(int) Math.ceil(list.size()*1.0/stepSize)
	//private Integer totalPage;
	//当前页数
	//private Integer curPage;
	
	public static List showPages(List list, int stepSize, int curPage){
		Integer totalPage = (int) Math.ceil(list.size()*1.0/stepSize);
		List result =new ArrayList();
		if(curPage<totalPage){
			for(int i=0; i<stepSize; i++){
				result.add(list.get((curPage-1)*stepSize+i));
			}
		}else {
			for(int i=0; (curPage-1)*stepSize+i<list.size(); i++){
				result.add(list.get((curPage-1)*stepSize+i));
			}
		}
		return result;
	}
	
	public static int getTotalPage(List list, int stepSize){
		return (int) Math.ceil(list.size()*1.0/stepSize);
	}
}
