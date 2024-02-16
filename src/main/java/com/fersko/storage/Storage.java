package com.fersko.storage;

import com.fersko.enums.TypeKeyStorage;
import com.fersko.statistics.StatisticsCollector;
import com.fersko.statistics.impl.DoubleStatisticsCollector;
import com.fersko.statistics.impl.LongStatisticsCollector;
import com.fersko.statistics.impl.StringStatisticsCollector;
import com.fersko.storage.impl.DoubleStorage;
import com.fersko.storage.impl.LongStorage;
import com.fersko.storage.impl.StringStorage;

import java.util.EnumMap;

public class Storage {
	private EnumMap<TypeKeyStorage, BaseTypeStorage<?>> data = new EnumMap<>(TypeKeyStorage.class);

	public Storage(DoubleStorage doubleStorage, LongStorage longStorage, StringStorage stringStorage) {
		data.put(TypeKeyStorage.REAL, doubleStorage);
		data.put(TypeKeyStorage.INTEGER, longStorage);
		data.put(TypeKeyStorage.STRING, stringStorage);
	}


	@SuppressWarnings("unchecked")
	public <T> void add(TypeKeyStorage key, T item) {
		BaseTypeStorage<T> storage = (BaseTypeStorage<T>) data.get(key);
		storage.add(item);
	}

	@SuppressWarnings("unchecked")
	public <T> BaseTypeStorage<T> get(TypeKeyStorage key) {
		return (BaseTypeStorage<T>) data.get(key);
	}

	public void showStatistics(boolean isFullStat) {
		data.forEach(((key, value) -> value.showStatistics(isFullStat)));
	}

}
