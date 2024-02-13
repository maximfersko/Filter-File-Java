package com.fersko;

import com.beust.jcommander.JCommander;
import com.fersko.args.ArgsHandler;
import com.fersko.utils.Runner;


public class Main {
	public static void main(String[] args) {
		ArgsHandler argsHandler = new ArgsHandler();
		JCommander jCommander = JCommander.newBuilder().addObject(argsHandler).build();
		try {
			jCommander.parse(args);
			System.out.println("prefix " + argsHandler.getPrefixFileName());
			System.out.println("path " + argsHandler.getPath());
			System.out.println("full stat " + argsHandler.isFullStat());
			System.out.println("short stat " + argsHandler.isShortStat());
			for (var f : argsHandler.getFiles()) {
				System.out.println(f);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		Runner runner = new Runner(argsHandler);
		runner.algorithm();


	}
}
