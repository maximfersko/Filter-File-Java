package com.fersko.reader.impl;

import com.fersko.reader.Reader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

class FileReaderImplTest {

	@Test
	void extractStrFromFileTest() throws IOException {
		Path tempFile = Files.createTempFile("test", ".txt");
		Files.writeString(tempFile, "Line 1\nLine 2\nLine 3");

		Reader fileReader = new FileReaderImpl();

		List<String> lines = fileReader.extractStrFromFile(tempFile.toString());

		Assertions.assertEquals(3, lines.size());
		Assertions.assertEquals("Line 1", lines.get(0));
		Assertions.assertEquals("Line 2", lines.get(1));
		Assertions.assertEquals("Line 3", lines.get(2));

		Files.deleteIfExists(tempFile);
	}
}
