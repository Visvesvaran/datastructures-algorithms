package com.learningdatastructures.stack;

import java.util.Arrays;

public class CharStack {

	private int maxSize;
	private char[] stackArray;
	private int top;

	public CharStack(int size) {
		this.maxSize = size;
		this.stackArray = new char[maxSize];
		this.top = -1;
	}
	
	public void push(char l) {
		if (!isFull()) {
			top++;
			stackArray[top] = l;
		} else {
			System.out.println("Stack is full.");
		}
	}

	public char pop() {
		if (!isEmpty()) {
			int popValue = top;
			top--;
			return stackArray[popValue];
		} else {
			System.out.println("Stack is empty.");
			return 0;
		}
	}

	public char peak() {
		return stackArray[top];
	}

	public boolean isEmpty() {
		return (top == -1);
	}

	public boolean isFull() {
		return (top == maxSize - 1);
	}
	
	public int getStackSize() {
		return maxSize;
	}

	@Override
	public String toString() {
		return "CharStack [stackArray=" + Arrays.toString(stackArray) + "]";
	}

}
