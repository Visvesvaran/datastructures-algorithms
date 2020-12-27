package com.pattern.singleton;

public class DateUtil_EagerInitialization {
	private static DateUtil_EagerInitialization instance = new DateUtil_EagerInitialization();
	
	private DateUtil_EagerInitialization() {

	}
	
	public static DateUtil_EagerInitialization getInstance() {
		return instance;
	}
}
