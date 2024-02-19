package com.fersko.writer.impl;

import com.fersko.storage.BaseTypeStorage;
import com.fersko.storage.impl.StringStorage;
import com.fersko.writer.Writer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class FileWriterImplTest {
	private Writer writer;
	private BaseTypeStorage<String> storage;

	@BeforeEach
	public void init() {
		writer = new FileWriterImpl();
		storage = new StringStorage();
		storage.add("Hello world!");
	}

	@Test
	void writeLinesTest() {
		String filePath = "test.txt";
		Path path = Paths.get(filePath);
		writer.writeLines(filePath, storage, true);
		try {
			String content = Files.readString(path);
			assertEquals("Hello world!\n", content);
			Files.deleteIfExists(path);
		} catch (IOException e) {
			fail("IOException thrown when reading the file: " + e.getMessage());
		}
	}

}
