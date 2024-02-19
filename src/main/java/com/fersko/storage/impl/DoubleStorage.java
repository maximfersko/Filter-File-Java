package com.fersko.storage.impl;

import com.fersko.statistics.StatisticsStrategy;
import com.fersko.statistics.StatisticsUtils;
import com.fersko.statistics.impl.DoubleStatisticsStrategy;
import com.fersko.storage.BaseTypeStorage;

public class DoubleStorage extends BaseTypeStorage<Double> {

	public DoubleStorage() {
		super();
	}

	@Override
	public void showStatistics(boolean isFullStat) {
		StatisticsStrategy<Double> strategy = new DoubleStatisticsStrategy();
		if (isFullStat) {
			StatisticsUtils.showStatistics(this, strategy);
		} else {
			StatisticsUtils.showShortStatistics(this, strategy);
		}
	}

}
