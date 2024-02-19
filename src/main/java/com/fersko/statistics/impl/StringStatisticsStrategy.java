package com.fersko.statistics.impl;

import com.fersko.statistics.StatisticsStrategy;
import com.fersko.statistics.consts.ConstsStatistics;
import com.fersko.storage.BaseTypeStorage;

public class StringStatisticsStrategy implements StatisticsStrategy<String> {

	@Override
	public void showFullStatistics(BaseTypeStorage<String> storage) {
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

	@Override
	public void showShortStatistics(BaseTypeStorage<String> storage) {
		System.out.println(ConstsStatistics.STRING_VALUE_DELIMETERS);
		System.out.println(ConstsStatistics.COUNT_LINES_STAT + storage.getData().size());
	}
}
