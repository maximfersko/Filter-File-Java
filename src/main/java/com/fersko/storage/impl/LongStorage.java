package com.fersko.storage.impl;

import com.fersko.statistics.StatisticsCollector;
import com.fersko.storage.BaseTypeStorage;

public class LongStorage extends BaseTypeStorage<Long> {
	private final StatisticsCollector<Long> statisticsCollector;
	public LongStorage(StatisticsCollector<Long> statisticsCollector) {
		super();
		this.statisticsCollector = statisticsCollector;
	}

	@Override
	public void showStatistics(boolean isFullStat) {
		statisticsCollector.showStatistics(this, isFullStat);
	}

}
