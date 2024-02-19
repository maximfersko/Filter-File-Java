package com.fersko.writer;

import com.fersko.storage.BaseTypeStorage;

public interface Writer {
	void writeLines(String filePath, BaseTypeStorage<?> storage, boolean rewrite);
}
