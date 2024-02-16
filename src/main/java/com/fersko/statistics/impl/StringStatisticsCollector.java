package com.fersko.statistics.impl;

import com.fersko.statistics.StatisticsCollector;
import com.fersko.storage.BaseTypeStorage;
import com.fersko.statistics.utils.ConstsStatistics;


public class StringStatisticsCollector implements StatisticsCollector<String> {

	@Override
	public void showStatistics(BaseTypeStorage<String> storage,boolean isFullStat) {
		if (isFullStat) {
			fullStatistics(storage);
		} else {
			shortStatistics(storage);
		}
	}

	private void shortStatistics(BaseTypeStorage<String> storage) {
		System.out.println(ConstsStatistics.STRING_VALUE_DELIMETERS);
		System.out.println(ConstsStatistics.COUNT_LINES_STAT + storage.getData().size());
	}

	private void fullStatistics(BaseTypeStorage<String> storage) {
		int shortestLength = storage.getData().get(0).length();
		int longestLength = storage.getData().get(0).length();
		String shortestStr = "";
		String longestStr = "";

		for (String str : storage.getData()) {
			if (str.length() < shortestLength) {
				shortestLength = str.length();
				shortestStr = str;
			}
			if (str.length() > longestLength) {
				longestLength = str.length();
				longestStr = str;
			}
		}

		System.out.println(ConstsStatistics.STRING_VALUE_DELIMETERS);
		System.out.println(ConstsStatistics.COUNT_LINES_STAT + storage.getData().size());
		System.out.println("|  Shortest string length: " + shortestStr + " | " + shortestLength + ConstsStatistics.CHARACTERS);
		System.out.println("|  Longest string length: " + longestStr + " | " + longestLength + ConstsStatistics.CHARACTERS);
	}
}
