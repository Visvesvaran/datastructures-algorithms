package com.prerequiste.oop;

public class Bird {

	String name;
	String size;
	String color;

	public Bird(String name, String size, String color) {
		super();
		this.name = name;
		this.size = size;
		this.color = color;
	}

	public void aboutMe() {
		System.out.println("Hello, my name is " + name + ".");
		System.out.println("I am a " + size + " size bird.");
		System.out.println("I am " + color + " in color.");
	}

	public void eat() {
		System.out.println("eating...");
	}

	public void fly() {
		System.out.println("flying...");
	}

}
