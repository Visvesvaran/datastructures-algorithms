package com.learningdatastructures.adt;

public class App {

	public static void main(String[] args) {
		Counter c1 = new Counter("HeartBeat");
		while(c1.getCurrentValue() < 72) {
			c1.increment();
		}
		System.out.println(c1.toString());
		
	}

}
