package com.fersko.statistics.impl;

import com.fersko.statistics.StatisticsStrategy;
import com.fersko.statistics.consts.ConstsStatistics;
import com.fersko.storage.BaseTypeStorage;

import java.util.List;
import java.util.LongSummaryStatistics;

public class LongStatisticsStrategy implements StatisticsStrategy<Long> {

	@Override
	public void showFullStatistics(BaseTypeStorage<Long> storage) {
		List<Long> data = storage.getData();
		LongSummaryStatistics statistics = data.stream()
				.mapToLong(Number::longValue)
				.summaryStatistics();

		System.out.println(ConstsStatistics.INTEGER_NUMBERS_DELIMETERS);
		System.out.println(ConstsStatistics.COUNT_LINES_STAT + data.size());
		System.out.println(ConstsStatistics.MIN_VALUE_STAT + statistics.getMin());
		System.out.println(ConstsStatistics.MAX_VALUE_STAT + statistics.getMax());
		System.out.println(ConstsStatistics.AVERAGE_VALUE_STAT + statistics.getAverage());
		System.out.println(ConstsStatistics.SUM_VALUE_STAT + statistics.getSum());
	}

	@Override
	public void showShortStatistics(BaseTypeStorage<Long> storage) {
		System.out.println(ConstsStatistics.INTEGER_NUMBERS_DELIMETERS);
		System.out.println(ConstsStatistics.COUNT_LINES_STAT + storage.getData().size());
	}
}
