package cn.sun.tasks.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import cn.sun.tasks.timeactual.domain.TimeActual;
import cn.sun.tasks.timeexpected.domain.TimeExpected;

public class MyTimeUtils {

	/**
	 * 获取最大预期完成时间
	 * @param timeExpecteds 所有预期时间集合
	 * @return 最大预期完成时间
	 */
	public static Date getMaxEndTimeExpected(List<TimeExpected> timeExpecteds) {

		List<Date> endTimeExpecteds = new ArrayList<>();
		for (TimeExpected timeExpected : timeExpecteds) {
			endTimeExpecteds.add(timeExpected.getEndTimeExpected());
		}
		if (endTimeExpecteds.size() != 0) {
			Collections.sort(endTimeExpecteds);
			return endTimeExpecteds.get(endTimeExpecteds.size() - 1);
		} else {
			return null;
		}
	}

	/**
	 * 获取最小预期完成时间
	 * @param timeExpecteds 所有预期时间集合
	 * @return 最小预期完成时间
	 */
	public static Date getMinEndTimeExpected(List<TimeExpected> timeExpecteds) {

		List<Date> endTimeExpecteds = new ArrayList<>();
		for (TimeExpected timeExpected : timeExpecteds) {
			endTimeExpecteds.add(timeExpected.getEndTimeExpected());
		}
		if (endTimeExpecteds.size() != 0) {
			Collections.sort(endTimeExpecteds);
			return endTimeExpecteds.get(0);
		} else {
			return null;
		}
	}

	/**
	 * 获取最大预期开始时间
	 * @param timeExpecteds 所有预期时间集合
	 * @return 最大预期开始时间
	 */
	public static Date getMaxBeginTimeExpected(List<TimeExpected> timeExpecteds) {

		List<Date> beginTimeExpecteds = new ArrayList<>();
		for (TimeExpected timeExpected : timeExpecteds) {
			beginTimeExpecteds.add(timeExpected.getBeginTimeExpected());
		}
		if (beginTimeExpecteds.size() != 0) {
			Collections.sort(beginTimeExpecteds);
			return beginTimeExpecteds.get(beginTimeExpecteds.size() - 1);
		} else {
			return null;
		}
	}
	
	/**
	 * 获取最小预期开始时间
	 * @param timeExpecteds 所有预期时间集合
	 * @return 最小预期开始时间
	 */
	public static Date getMinBeginTimeExpected(List<TimeExpected> timeExpecteds) {

		List<Date> beginTimeExpecteds = new ArrayList<>();
		for (TimeExpected timeExpected : timeExpecteds) {
			beginTimeExpecteds.add(timeExpected.getBeginTimeExpected());
		}
		if (beginTimeExpecteds.size() != 0) {
			Collections.sort(beginTimeExpecteds);
			return beginTimeExpecteds.get(0);
		} else {
			return null;
		}
	}
	
	/**
	 * 获取最大实际完成时间
	 * @param timeActuals 所有实际时间的集合
	 * @return 最大实际完成时间
	 */
	public static Date getMaxEndTimeActual(List<TimeActual> timeActuals) {

		List<Date> endTimeActuals = new ArrayList<>();
		for (TimeActual timeActual : timeActuals) {
			endTimeActuals.add(timeActual.getEndTimeActual());
		}
		if (endTimeActuals.size() != 0) {
			Collections.sort(endTimeActuals);
			return endTimeActuals.get(endTimeActuals.size() - 1);
		} else {
			return null;
		}
	}
}
