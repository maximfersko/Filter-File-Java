package com.fersko.parser;

public interface Parser<T> {
	T parse(String elm);

	boolean isParse(String elm);
}
