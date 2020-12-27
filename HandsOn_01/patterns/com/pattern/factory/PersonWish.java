package com.pattern.factory;

public class PersonWish {
	
	public Person getWish(String type, String msg) {
		Person p = PersonFactory.createPerson(type);
		
		p.wish(msg);
		
		return p;
	}
}
