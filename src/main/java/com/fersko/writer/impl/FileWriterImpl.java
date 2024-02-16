package com.fersko.writer.impl;

import com.fersko.storage.BaseTypeStorage;
import com.fersko.writer.Writer;
import lombok.extern.slf4j.Slf4j;

import java.io.FileWriter;
import java.io.IOException;

@Slf4j
public class FileWriterImpl implements Writer {

	public static final String DEFAULT_INTEGER_FILE = "integers.txt";
	public static final String DEFAULT_REAL_FILE = "floats.txt";
	public static final String DEFAULT_STRING_FILE = "strings.txt";


	@Override
	public void writeLines(String filePath, BaseTypeStorage<?> storage, boolean rewrite) {
		try (FileWriter fileWriter = new FileWriter(filePath, rewrite)) {
			for (var line : storage.getData()) {
				fileWriter.write(line + "\n");
			}
			fileWriter.flush();
		} catch (IOException e) {
			log.info(e.getMessage());
		}
	}

}
