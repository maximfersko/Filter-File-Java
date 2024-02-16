package com.fersko.storage.impl;

import com.fersko.statistics.StatisticsCollector;
import com.fersko.storage.BaseTypeStorage;

public class StringStorage extends BaseTypeStorage<String> {
	private final StatisticsCollector<String> statisticsCollector;
	public StringStorage(StatisticsCollector<String> statisticsCollector) {
		super();
		this.statisticsCollector = statisticsCollector;
	}

	@Override
	public void showStatistics(boolean isFullStat) {
		statisticsCollector.showStatistics(this,isFullStat);
	}

}
