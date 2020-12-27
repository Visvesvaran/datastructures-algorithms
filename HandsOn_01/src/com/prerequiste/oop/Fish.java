package com.prerequiste.oop;

public class Fish {

	String name;
	String size;
	String color;

	public Fish(String name, String size, String color) {
		super();
		this.name = name;
		this.size = size;
		this.color = color;
	}

	public void aboutMe() {
		System.out.println("Hello, my name is " + name + ".");
		System.out.println("I am " + size + " size fish.");
		System.out.println("I am " + color + " in color.");
	}

	public void eat() {
		System.out.println("eating...");
	}

	public void swim() {
		System.out.println("swimming...");
	}

}
