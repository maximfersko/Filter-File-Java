package com.fersko.writer.impl;

import com.fersko.writer.Writer;
import lombok.extern.slf4j.Slf4j;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@Slf4j
public class FileWriterImpl implements Writer {

	@Override
	public void writeLines(String filePath, List<?> storage, boolean rewrite) {
		try (FileWriter fileWriter = new FileWriter(filePath, rewrite)) {
			for (var line : storage) {
				fileWriter.write(line + "\n");
			}
			fileWriter.flush();
		} catch (IOException e) {
			log.info(e.getMessage());
		}
	}

}
