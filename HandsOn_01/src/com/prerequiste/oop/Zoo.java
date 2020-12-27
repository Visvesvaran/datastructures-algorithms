package com.prerequiste.oop;

public class Zoo {
	
	public static void main(String args[]) {
		
		Animal a1 = new Animal("Elephant", 50, "Female", 400, "Black");
		Animal a2 = new Animal("Tortoise", 300, "Male", 300, "Brown");
		
		a1.aboutMe();
		a2.aboutMe();
		
		Bird b1 = new Bird("Eagle", "medium", "Brown");
		b1.aboutMe();
		Fish f1 = new Fish("Whale", "the largest", "Blue");
		f1.aboutMe();
		
	}

}
