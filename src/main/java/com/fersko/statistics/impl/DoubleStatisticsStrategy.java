package com.fersko.statistics.impl;

import com.fersko.statistics.StatisticsStrategy;
import com.fersko.statistics.consts.ConstsStatistics;
import com.fersko.storage.BaseTypeStorage;

import java.util.DoubleSummaryStatistics;

public class DoubleStatisticsStrategy implements StatisticsStrategy<Double> {

	@Override
	public void showFullStatistics(BaseTypeStorage<Double> storage) {
		DoubleSummaryStatistics statistics = storage.getData().parallelStream()
				.mapToDouble(Number::doubleValue)
				.summaryStatistics();

		System.out.println(ConstsStatistics.REAL_NUMBERS_DELIMETERS);
		System.out.println(ConstsStatistics.COUNT_LINES_STAT + storage.getData().size());
		System.out.println(ConstsStatistics.MIN_VALUE_STAT + statistics.getMin());
		System.out.println(ConstsStatistics.MAX_VALUE_STAT + statistics.getMax());
		System.out.println(ConstsStatistics.AVERAGE_VALUE_STAT + statistics.getAverage());
		System.out.println(ConstsStatistics.SUM_VALUE_STAT + statistics.getSum());
	}

	@Override
	public void showShortStatistics(BaseTypeStorage<Double> storage) {
		System.out.println(ConstsStatistics.REAL_NUMBERS_DELIMETERS);
		System.out.println(ConstsStatistics.COUNT_LINES_STAT + storage.getData().size());
	}
}
