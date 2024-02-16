package com.fersko.statistics.impl;

import com.fersko.statistics.StatisticsCollector;
import com.fersko.storage.BaseTypeStorage;
import com.fersko.statistics.utils.ConstsStatistics;

import java.util.LongSummaryStatistics;


public class LongStatisticsCollector implements StatisticsCollector<Long> {

	@Override
	public void showStatistics(BaseTypeStorage<Long> storage,boolean isFullStat) {
		if (isFullStat) {
			fullStatistics(storage);
		} else {
			shortStatistics(storage);
		}
	}

	private void fullStatistics(BaseTypeStorage<Long> storage) {
		LongSummaryStatistics statistics = storage.getData().parallelStream()
				.mapToLong(Number::longValue)
				.summaryStatistics();
		System.out.println(ConstsStatistics.INTEGER_NUMBERS_DELIMETERS);
		System.out.println(ConstsStatistics.COUNT_LINES_STAT + storage.getData().size());
		System.out.println(ConstsStatistics.MIN_VALUE_STAT + statistics.getMin());
		System.out.println(ConstsStatistics.MAX_VALUE_STAT + statistics.getMax());
		System.out.println(ConstsStatistics.AVERAGE_VALUE_STAT + statistics.getAverage());
		System.out.println(ConstsStatistics.SUM_VALUE_STAT + statistics.getSum());
	}

	private void shortStatistics(BaseTypeStorage<Long> storage) {
		System.out.println(ConstsStatistics.INTEGER_NUMBERS_DELIMETERS);
		System.out.println(ConstsStatistics.COUNT_LINES_STAT + storage.getData().size());
	}
}
