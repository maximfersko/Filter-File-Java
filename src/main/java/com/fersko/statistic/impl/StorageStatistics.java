package com.fersko.statistic.impl;

import com.fersko.enums.TypeStatistics;
import com.fersko.statistic.BaseStatistic;
import com.fersko.storage.BaseStorage;
import lombok.AllArgsConstructor;

import java.util.Collections;

@AllArgsConstructor
public class StorageStatistics implements BaseStatistic {
	private final BaseStorage<?> storage;

	@Override
	public void showStatistics(TypeStatistics typeStatistics) {

	}

	private void shortStatistics() {

	}

	private void fullStatistics() {
		System.out.println("Short statistics: ");
		System.out.println();
	}

}
