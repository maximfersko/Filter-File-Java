package com.fersko.storage.impl;

import com.fersko.statistics.StatisticsCollector;
import com.fersko.storage.BaseTypeStorage;

public class DoubleStorage extends BaseTypeStorage<Double> {
	private final StatisticsCollector<Double> statisticsCollector;
	public DoubleStorage( StatisticsCollector<Double> statisticsCollector) {
		super();
		this.statisticsCollector = statisticsCollector;
	}

	@Override
	public void showStatistics(boolean isFullStat) {
		statisticsCollector.showStatistics(this, isFullStat);
	}

}
