package com.pattern.factory;

public class PersonFactory {

	public static Person createPerson(String type) {
		Person p = null;

		if (type.equals("Male")) {
			p = new Male();
		} else if (type.equals("Female")) {
			p = new Female();
		}

		return p;
	}
}
