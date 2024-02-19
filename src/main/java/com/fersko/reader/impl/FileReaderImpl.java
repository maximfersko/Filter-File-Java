package com.fersko.reader.impl;

import com.fersko.reader.Reader;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class FileReaderImpl implements Reader {
	@Override
	public List<String> extractStrFromFile(String filename) {
		List<String> lines = new ArrayList<>();
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filename))) {
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				lines.add(line);
			}
		} catch (IOException e) {
			log.error(e.getMessage());
		}
		return lines;
	}

}
 