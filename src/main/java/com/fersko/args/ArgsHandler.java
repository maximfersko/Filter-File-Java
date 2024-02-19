package com.fersko.args;

import com.beust.jcommander.Parameter;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class ArgsHandler {
	@Parameter(names = { "-o" }, description = "Path to the directory where the results will be saved")
	private String path;

	@Parameter(names = { "-p" }, description = "Prefix for the filename")
	private String prefixFileName;

	@Parameter(names = { "-f" }, description = "Display full statistics")
	private boolean fullStat;

	@Parameter(names = { "-s" }, description = "Display short statistics")
	private boolean shortStat;

	@Parameter(names = { "-a" }, description = "Append data to the file instead of overwriting it")
	private boolean addToFile = false;

	@Parameter(description = "List of files to process")
	private List<String> files = new ArrayList<>();
}

