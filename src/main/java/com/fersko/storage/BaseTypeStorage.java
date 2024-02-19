package com.fersko.storage;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseTypeStorage<T> {
	protected final List<T> data;

	protected BaseTypeStorage() {
		data = new ArrayList<>();
	}

	public abstract void showStatistics(boolean isFullStat);

	public void add(T item) {
		data.add(item);
	}

	public List<T> getData() {
		return new ArrayList<>(data);
	}


}
