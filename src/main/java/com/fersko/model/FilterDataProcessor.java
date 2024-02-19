package com.fersko.model;


import com.fersko.args.ArgsHandler;
import com.fersko.enums.TypeKeyStorage;
import com.fersko.parser.Parser;
import com.fersko.parser.impl.ParserDouble;
import com.fersko.parser.impl.ParserLong;
import com.fersko.reader.Reader;
import com.fersko.reader.impl.FileReaderImpl;
import com.fersko.storage.Storage;
import com.fersko.writer.impl.FileWriterImpl;
import lombok.extern.slf4j.Slf4j;

import java.util.List;


@Slf4j
public class FilterDataProcessor {
	private final Parser<Double> doubleParser = new ParserDouble();
	private final Parser<Long> longParser = new ParserLong();
	private ArgsHandler args;
	private Storage storage = new Storage();
	private Reader reader;

	public FilterDataProcessor(ArgsHandler args) {
		this.args = args;
		reader = new FileReaderImpl();
	}

	private FilterDataProcessor() {

	}

	public void printStatistics() {
		System.out.println("\n========================  Statistics  =======================");
		storage.showStatistics(args.isFullStat());
		System.out.println("=============================================================\n");
	}

	public void extractToStorage() {
		for (var file : args.getFiles()) {
			List<String> lines = reader.extractStrFromFile(file);
			try {
				processLines(lines);
			} catch (NumberFormatException e) {
				log.error("Error processing lines from file {}: {}", file, e.getMessage());
			}
		}
	}

	private void processLines(List<String> lines) {
		for (var line : lines) {
			try {
				processLine(line);
			} catch (NumberFormatException e) {
				log.error("Error processing line '{}': {}", line, e.getMessage());
			}
		}
	}

	private void processLine(String line) {
		if (doubleParser.isParse(line)) {
			storage.add(TypeKeyStorage.REAL, doubleParser.parse(line));
		} else if (longParser.isParse(line)) {
			storage.add(TypeKeyStorage.INTEGER, longParser.parse(line));
		} else {
			storage.add(TypeKeyStorage.STRING, line);
		}
	}


	public void writeDataToFile() {
		FileWriterImpl writer = new FileWriterImpl();
		String path = args.getPath() != null ? args.getPath() : "";
		String prefix = args.getPrefixFileName() != null ? args.getPrefixFileName() : "";
		writer.writeLines(path + prefix + FileWriterImpl.DEFAULT_REAL_FILE, storage.get(TypeKeyStorage.REAL), args.isAddToFile());
		writer.writeLines(path + prefix + FileWriterImpl.DEFAULT_INTEGER_FILE, storage.get(TypeKeyStorage.INTEGER), args.isAddToFile());
		writer.writeLines(path + prefix + FileWriterImpl.DEFAULT_STRING_FILE, storage.get(TypeKeyStorage.STRING), args.isAddToFile());
	}
}
