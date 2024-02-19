package com.fersko.parser.impl;

import com.fersko.parser.Parser;

import java.util.regex.Pattern;

public class ParserLong implements Parser<Long> {
	private static final String PATTERN_INTEGER_NUMBER = "-?\\d+";

	@Override
	public Long parse(String elm) {
		return Long.parseLong(elm);
	}

	@Override
	public boolean isParse(String elm) {
		return Pattern.matches(PATTERN_INTEGER_NUMBER, elm);
	}
}
