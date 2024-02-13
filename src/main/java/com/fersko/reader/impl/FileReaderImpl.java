package com.fersko.reader.impl;

import com.fersko.reader.Reader;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@AllArgsConstructor
public class FileReaderImpl implements Reader {
	private final List<String> pathToFiles;

	@Override
	public List<String> extractStrFromFile() {
		List<String> lines = new ArrayList<>();
		for (var pathToFile : pathToFiles) {
			try (BufferedReader bufferedReader = new BufferedReader(new FileReader(pathToFile))) {
				String line;
				while ((line = bufferedReader.readLine()) != null) {
					lines.add(line);
				}
			} catch (IOException e) {
				log.info(e.getMessage());
			}
		}
		return lines;
	}
}
