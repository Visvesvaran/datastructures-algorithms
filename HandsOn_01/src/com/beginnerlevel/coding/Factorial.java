package com.beginnerlevel.coding;

public class Factorial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=0; i<10; i++) {
			System.out.println(i+"! is "+fact(i));
		}

	}
	
	private static int fact(int n) {
		if(0 == n) {
			System.out.println(1);
			return 1;
		}
		else {
			System.out.print(n);
			System.out.print("x");
			return n*fact(n-1);
		}
	}

}
