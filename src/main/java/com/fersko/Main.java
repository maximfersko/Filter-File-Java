package com.fersko;

import com.beust.jcommander.JCommander;
import com.fersko.args.ArgsHandler;
import com.fersko.model.FilterDataProcessor;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class Main {
	public static void main(String[] args) {
		ArgsHandler argsHandler = new ArgsHandler();
		JCommander jCommander = JCommander.newBuilder().addObject(argsHandler).build();

		try {
			jCommander.parse(args);
		} catch (Exception e) {
			log.error("Error parsing command line arguments: {}", e.getMessage());
			jCommander.usage();
		}

		FilterDataProcessor runner = new FilterDataProcessor(argsHandler);
		runner.extractToStorage();
		runner.printStatistics();
		runner.writeDataToFile();
	}
}
