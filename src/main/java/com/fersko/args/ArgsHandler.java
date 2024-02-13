package com.fersko.args;

import com.beust.jcommander.Parameter;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class ArgsHandler {
	@Parameter(names = { "-o" }, description = "Path to directory with result")
	private String path;

	@Parameter(names = { "-p" }, description = "Prefix filename")
	private String prefixFileName;

	@Parameter(names = { "-f" }, description = "Full stastic")
	private boolean fullStat;

	@Parameter(names = { "-s" }, description = "Short stastic")
	private boolean shortStat;

	@Parameter(names = { "-a" }, description = "")
	private boolean addToFile = false;

	@Parameter
	private List<String> files = new ArrayList<>();

}
