package com.fersko.utils;

public interface Parser<T> {
	T parse(String elm);

	boolean isParse(String elm);
}
