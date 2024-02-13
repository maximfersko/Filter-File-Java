package com.fersko.storage;

import lombok.Getter;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

@Getter
public class TypeStorage {
	private final Map<String, BaseStorage<?>> storage = new HashMap<>();

	public TypeStorage(String... types) {
		for (var type : types) {
			if (type.toLowerCase(Locale.ROOT).contentEquals("long")) {
				this.createStorage(type, Long.class);
			} else if (type.toLowerCase(Locale.ROOT).contentEquals("string")) {
				this.createStorage(type, String.class);
			} else if (type.toLowerCase(Locale.ROOT).contentEquals("double")) {
				this.createStorage(type, Double.class);
			}
		}
	}

	@SuppressWarnings("unchecked")
	public <T> void add(String typename, T item) {
		BaseStorage<?> baseStorage = storage.get(typename);
		if (baseStorage != null && item.getClass().equals(baseStorage.getDataType())) {
			BaseStorage<T> castedStorage = (BaseStorage<T>) baseStorage;
			castedStorage.add(item);
		}
	}

	public <T> void createStorage(String key, Class<T> dataType) {
		storage.put(key, new BaseStorage<>(dataType));
	}

	public List<?> get(String typename) {
		return storage.get(typename).getData();
	}

}
