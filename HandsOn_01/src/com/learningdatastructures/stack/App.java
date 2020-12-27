package com.learningdatastructures.stack;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack s1 = new Stack(10);
		s1.push(10);
		s1.push(20);
		s1.push(30);
		s1.push(40);
		s1.push(50);
		
		while(!s1.isEmpty()) {
			long l = s1.pop();
			System.out.println(l);
		}
		
		Stack s2 = new Stack(3);
		s2.push(10);
		s2.push(20);
		s2.push(30);
		s2.push(40);
		s2.push(50);
		
		while(!s2.isEmpty()) {
			long l = s2.pop();
			System.out.println(l);
		}
		
		System.out.println(reverseString("Hello"));
		
		BasicCalculator b1 = new BasicCalculator();
		String expression = "1+3";
		System.out.println(b1.calculate(expression));

	}
	
	public static String reverseString(String s) {
		CharStack cStack = new CharStack(s.length());
		for (int i = 0; i < cStack.getStackSize(); i++) {
			cStack.push(s.charAt(i));
		}
		StringBuilder b = new StringBuilder();
		while(!cStack.isEmpty()) {
			b.append(cStack.pop());
		}
		
		return b.toString();
	}

}
