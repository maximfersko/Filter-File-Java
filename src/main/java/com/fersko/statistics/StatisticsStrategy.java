package com.fersko.statistics;

import com.fersko.storage.BaseTypeStorage;

public interface StatisticsStrategy<T> {
	void showFullStatistics(BaseTypeStorage<T> storage);

	void showShortStatistics(BaseTypeStorage<T> storage);
}
