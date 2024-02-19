package com.fersko.statistics.impl;

import com.fersko.statistics.StatisticsStrategy;
import com.fersko.statistics.consts.ConstsStatistics;
import com.fersko.storage.BaseTypeStorage;

import java.util.DoubleSummaryStatistics;
import java.util.List;

public class DoubleStatisticsStrategy implements StatisticsStrategy<Double> {

	@Override
	public void showFullStatistics(BaseTypeStorage<Double> storage) {
		List<Double> data = storage.getData();
		DoubleSummaryStatistics statistics = data.stream()
				.mapToDouble(Number::doubleValue)
				.summaryStatistics();


		System.out.println(ConstsStatistics.REAL_NUMBERS_DELIMETERS);
		System.out.printf(ConstsStatistics.FORMAT_PATTERN, ConstsStatistics.COUNT_LINES_STAT, data.size());
		System.out.printf(ConstsStatistics.FORMAT_PATTERN, ConstsStatistics.MIN_VALUE_STAT, statistics.getMin());
		System.out.printf(ConstsStatistics.FORMAT_PATTERN, ConstsStatistics.MAX_VALUE_STAT, statistics.getMax());
		System.out.printf(ConstsStatistics.FORMAT_PATTERN, ConstsStatistics.AVERAGE_VALUE_STAT, statistics.getAverage());
		System.out.printf(ConstsStatistics.FORMAT_PATTERN, ConstsStatistics.SUM_VALUE_STAT, statistics.getSum());
	}

	@Override
	public void showShortStatistics(BaseTypeStorage<Double> storage) {
		System.out.println(ConstsStatistics.REAL_NUMBERS_DELIMETERS);
		System.out.printf(ConstsStatistics.FORMAT_PATTERN, ConstsStatistics.COUNT_LINES_STAT, storage.getData().size());
	}
}
