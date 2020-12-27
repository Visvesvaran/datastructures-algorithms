package com.pattern.singleton;

public class DateUtil_LazyInitialization {
	private static DateUtil_LazyInitialization instance = null;
	
	private DateUtil_LazyInitialization() {

	}
	
	public static DateUtil_LazyInitialization getInstance() {
		if(instance == null) {
			instance = new DateUtil_LazyInitialization();
		}
		return instance;
	}
}
