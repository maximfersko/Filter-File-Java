package com.fersko.storage.impl;

import com.fersko.statistics.StatisticsStrategy;
import com.fersko.statistics.StatisticsUtils;
import com.fersko.statistics.impl.StringStatisticsStrategy;
import com.fersko.storage.BaseTypeStorage;

public class StringStorage extends BaseTypeStorage<String> {

	public StringStorage() {
		super();
	}

	@Override
	public void showStatistics(boolean isFullStat) {
		StatisticsStrategy<String> strategy = new StringStatisticsStrategy();
		if (isFullStat) {
			StatisticsUtils.showStatistics(this, strategy);
		} else {
			StatisticsUtils.showShortStatistics(this, strategy);
		}
	}

}
