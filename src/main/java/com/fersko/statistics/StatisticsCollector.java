package com.fersko.statistics;

import com.fersko.storage.BaseTypeStorage;

public interface StatisticsCollector<T> {
	 void showStatistics(BaseTypeStorage<T> storage,boolean isFullStat);

}
