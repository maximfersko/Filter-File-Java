package com.fersko;

import com.beust.jcommander.JCommander;
import com.fersko.args.ArgsHandler;
import com.fersko.parser.Runner;


public class Main {
	public static void main(String[] args) {
		ArgsHandler argsHandler = new ArgsHandler();
		JCommander jCommander = JCommander.newBuilder().addObject(argsHandler).build();

		try {
			jCommander.parse(args);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		Runner runner = new Runner(argsHandler);
		runner.extractToStorage();
		runner.printStatistics();
	}
}
