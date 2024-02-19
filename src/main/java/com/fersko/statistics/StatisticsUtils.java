package com.fersko.statistics;

import com.fersko.storage.BaseTypeStorage;

public class StatisticsUtils {

	private StatisticsUtils() {

	}

	public static <T> void showStatistics(BaseTypeStorage<T> storage, StatisticsStrategy<T> strategy) {
		strategy.showFullStatistics(storage);
	}

	public static <T> void showShortStatistics(BaseTypeStorage<T> storage, StatisticsStrategy<T> strategy) {
		strategy.showShortStatistics(storage);
	}
}
