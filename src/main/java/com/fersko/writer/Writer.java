package com.fersko.writer;

import java.util.List;

public interface Writer {
	void writeLines(String filePath, List<?> storage, boolean rewrite);
}
