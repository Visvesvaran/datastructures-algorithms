package com.learningdatastructures.queue;

public class Queue {

	private int maxSize;
	private long[] queueArray;
	private int front;
	private int rear;
	private int nItems;
	
	public Queue (int size) {
		this.maxSize = size;
		this.queueArray = new long[maxSize];
		front = 0;
		rear = -1;
		nItems = 0;
		
	}
	
	public void insert(long l) {
		rear++;
		queueArray[rear] = l;
	}
	
	public long remove() {
		long temp = queueArray[front];
		front++;
		if(front == maxSize) {
			front = 0;
		}
		nItems--;
		return temp;
	}
	
	public long peek() {
		return queueArray[front];
	}
	
	public void view() {
		System.out.print("[");
		for (int i = 0; i < queueArray.length; i++) {
			System.out.print(queueArray[i]);
		}
		System.out.print("]");
	}
	
	public boolean isEmpty() {
		return nItems == 0;
	}
	
	public boolean isFull() {
		return nItems == maxSize;
	}
}
