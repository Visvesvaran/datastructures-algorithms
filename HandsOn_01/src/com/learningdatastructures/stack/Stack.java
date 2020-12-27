package com.learningdatastructures.stack;

public class Stack {

	private int maxSize;
	private long[] stackArray;
	private int top;

	public Stack(int size) {
		this.maxSize = size;
		this.stackArray = new long[maxSize];
		this.top = -1;
	}

	public void push(long l) {
		if (!isFull()) {
			top++;
			stackArray[top] = l;
		} else {
			System.out.println("Stack is full.");
		}
	}

	public long pop() {
		if (!isEmpty()) {
			int popValue = top;
			top--;
			return stackArray[popValue];
		} else {
			System.out.println("Stack is empty.");
			return -1;
		}
	}

	public long peak() {
		return stackArray[top];
	}

	public boolean isEmpty() {
		return (top == -1);
	}

	public boolean isFull() {
		return (top == maxSize - 1);
	}

}
