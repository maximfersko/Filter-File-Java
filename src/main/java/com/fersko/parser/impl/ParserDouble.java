package com.fersko.parser.impl;

import com.fersko.parser.Parser;

import java.util.regex.Pattern;

public class ParserDouble implements Parser<Double> {
	private static final String PATTERN_REAL_NUMBER = "-?\\d*\\.\\d+(E-?\\d+)?";

	@Override
	public Double parse(String elm) {
		return Double.parseDouble(elm);
	}

	@Override
	public boolean isParse(String elm) {
		return Pattern.matches(PATTERN_REAL_NUMBER, elm);
	}
}
