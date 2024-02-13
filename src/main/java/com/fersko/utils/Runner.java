package com.fersko.utils;


import com.fersko.args.ArgsHandler;
import com.fersko.reader.Reader;
import com.fersko.reader.impl.FileReaderImpl;
import com.fersko.storage.TypeStorage;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class Runner {
	private final ArgsHandler args;

	public void algorithm() {
		Reader reader = new FileReaderImpl(args.getFiles());
		Parser<Double> parser = new ParserDouble();
		Parser<Long> parser1 = new ParserLong();

		TypeStorage typeStorage = new TypeStorage("Double", "Long", "String");

		for (var line : reader.extractStrFromFile()) {
			try {
				if (parser.isParse(line)) {
					typeStorage.add("Double", parser.parse(line));
				} else if (parser1.isParse(line)) {
					typeStorage.add("Long", parser1.parse(line));
				} else {
					typeStorage.add("String", line);
				}
			} catch (NumberFormatException e) {
				log.info(e.getMessage());
			}
		}

		System.out.println(typeStorage.get("Double"));
		System.out.println(typeStorage.get("String"));
		System.out.println(typeStorage.get("Long"));

//		Writer writer = new FileWriterImpl();
//		writer.writeLines(args.getPath(), storage, args.isAddToFile());
	}
}
