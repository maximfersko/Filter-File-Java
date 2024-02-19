package com.fersko.storage.impl;

import com.fersko.statistics.StatisticsStrategy;
import com.fersko.statistics.StatisticsUtils;
import com.fersko.statistics.impl.LongStatisticsStrategy;
import com.fersko.storage.BaseTypeStorage;

public class LongStorage extends BaseTypeStorage<Long> {

	public LongStorage() {
		super();
	}

	@Override
	public void showStatistics(boolean isFullStat) {
		StatisticsStrategy<Long> strategy = new LongStatisticsStrategy();
		if (isFullStat) {
			StatisticsUtils.showStatistics(this, strategy);
		} else {
			StatisticsUtils.showShortStatistics(this, strategy);
		}
	}

}
