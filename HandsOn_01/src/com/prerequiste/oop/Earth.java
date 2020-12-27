package com.prerequiste.oop;

public class Earth {

	public static void main(String args[]) {
		
		Human h1 = new Human("Tom", 25, 76, "Blue");
		Human h2 = new Human("Joe", 28, 68, "Green");
		
		h1.speak();
		h2.speak();
	}
}
