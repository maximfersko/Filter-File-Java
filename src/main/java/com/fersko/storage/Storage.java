package com.fersko.storage;

import com.fersko.enums.TypeKeyStorage;
import com.fersko.storage.impl.DoubleStorage;
import com.fersko.storage.impl.LongStorage;
import com.fersko.storage.impl.StringStorage;

import java.util.EnumMap;

public class Storage {
	private EnumMap<TypeKeyStorage, BaseTypeStorage<?>> data = new EnumMap<>(TypeKeyStorage.class);

	public Storage() {
		data.put(TypeKeyStorage.REAL, new DoubleStorage());
		data.put(TypeKeyStorage.INTEGER, new LongStorage());
		data.put(TypeKeyStorage.STRING, new StringStorage());
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
