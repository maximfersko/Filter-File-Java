package com.fersko.storage;

import java.util.List;


public interface Storage<T> {
	void add(T item);

	List<T> getData();

	Class<T> getDataType();
}
