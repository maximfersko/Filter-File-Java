package com.fersko.storage;

import java.util.ArrayList;
import java.util.List;

public class BaseStorage<T> implements Storage<T> {
	private final Class<T> type;
	private final List<T> data;

	public BaseStorage(Class<T> type) {
		this.type = type;
		data = new ArrayList<>();
	}

	@Override
	public void add(T item) {
		data.add(item);
	}

	@Override
	public List<T> getData() {
		return new ArrayList<>(data);
	}

	@Override
	public Class<T> getDataType() {
		return type;
	}


}
