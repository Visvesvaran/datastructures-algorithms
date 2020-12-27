package com.prerequiste.oop;

public class Animal {
	
	String name;
	int age;
	String gender;
	int weightInPounds;
	String color;

	
	
	public Animal(String name, int age, String gender, int weightInPounds, String color) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.weightInPounds = weightInPounds;
		this.color = color;
	}

	public void aboutMe() {
		System.out.println("Hello, my name is "+ name + ".");
		System.out.println("I am " + color + " in color.");
		System.out.println("I am "+ age +" years old.");
		System.out.println("I am a "+ gender + ".");
		System.out.println("My wieght is "+ weightInPounds +" pounds.");
		
		
	}
	
	public void eat() {
		System.out.println("eating...");
	}
	
	public void sleep() {
		System.out.println("sleeping...");
	}

}
