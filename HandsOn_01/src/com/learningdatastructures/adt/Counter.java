package com.learningdatastructures.adt;

public class Counter {

	private String name = null;
	private int count;

	public Counter(String s) {
		this.name = s;
	}

	public void increment() {
		count++;
	}

	public Integer getCurrentValue() {
		return count;
	}

	@Override
	public String toString() {
		return "Counter [name=" + name + ", count=" + count + "]";
	}

}
