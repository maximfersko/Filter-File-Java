package com.fersko.args;

import com.beust.jcommander.IStringConverter;

import java.nio.file.FileSystems;
import java.nio.file.PathMatcher;

public class TxtFileConverter implements IStringConverter<String> {
	private static final String FILE_PATTERN = "glob:*.txt";
	private static final PathMatcher PATH_MATCHER = FileSystems.getDefault().getPathMatcher(FILE_PATTERN);

	@Override
	public String convert(String value) {
		if (!PATH_MATCHER.matches(FileSystems.getDefault().getPath(value))) {
			throw new IllegalArgumentException("The provided file is not a .txt file: " + value);
		}
		return value;
	}
}
