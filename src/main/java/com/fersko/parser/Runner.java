package com.fersko.parser;


import com.fersko.args.ArgsHandler;
import com.fersko.enums.TypeKeyStorage;
import com.fersko.reader.Reader;
import com.fersko.reader.impl.FileReaderImpl;
import com.fersko.statistics.impl.DoubleStatisticsCollector;
import com.fersko.statistics.impl.LongStatisticsCollector;
import com.fersko.statistics.impl.StringStatisticsCollector;
import com.fersko.storage.Storage;
import com.fersko.storage.impl.DoubleStorage;
import com.fersko.storage.impl.LongStorage;
import com.fersko.storage.impl.StringStorage;
import com.fersko.writer.impl.FileWriterImpl;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class Runner {
	private ArgsHandler args;
	private Storage storage = new Storage(
				new DoubleStorage(new DoubleStatisticsCollector()),
			new LongStorage(new LongStatisticsCollector()),
			new StringStorage(new StringStatisticsCollector())
			);
	private Reader reader;
	private final Parser<Double> doubleParser = new ParserDouble();
	private final Parser<Long> longParser = new ParserLong();

	public Runner(ArgsHandler args) {
		this.args = args;
		reader = new FileReaderImpl(args.getFiles());
	}

	private Runner() {

	}

	public void printStatistics() {
		System.out.println("\n========================  Statistics  =======================");
		storage.showStatistics(args.isFullStat());
		System.out.println("=============================================================\n");
	}

	public void extractToStorage() {
		for (var line : reader.extractStrFromFile()) {
			try {
				if (doubleParser.isParse(line)) {
					storage.add(TypeKeyStorage.REAL, doubleParser.parse(line));
				} else if (longParser.isParse(line)) {
					storage.add(TypeKeyStorage.INTEGER, longParser.parse(line));
				} else {
					storage.add(TypeKeyStorage.STRING, line);
				}
			} catch (NumberFormatException e) {
				log.info(e.getMessage());
			}
		}
	}

	public void writeDataToFile() {
		FileWriterImpl writer = new FileWriterImpl();
		String pathAndPrefix = args.getPath() + args.getPrefixFileName();
		writer.writeLines(pathAndPrefix + FileWriterImpl.DEFAULT_REAL_FILE, storage.get(TypeKeyStorage.REAL), args.isAddToFile());
		writer.writeLines(pathAndPrefix + FileWriterImpl.DEFAULT_INTEGER_FILE, storage.get(TypeKeyStorage.INTEGER), args.isAddToFile());
		writer.writeLines(pathAndPrefix + FileWriterImpl.DEFAULT_STRING_FILE, storage.get(TypeKeyStorage.STRING), args.isAddToFile());
	}
}
