package com.beginnerlevel.coding;

public class FibonacciSeries_01 {

	public static void main(String[] args) {
		int f = 14;
		for (int i = 0; i <= f; i++) {
			fibonacci(i);
		}

	}

	static void fibonacci(int f) {
		System.out.println("Fibonacci series for " + f + " <<<");
		int x0 = 0;
		int x1 = 0;
		int xp = 0;
		int xn = 0;
		for (int i = 0; i <= f; i++) {
			if(i == 0) {
				x0 = 0;
				xn = x0+x1;
			}
			if(i == 1) {
				x1 = 1;
				xn = x0+x1;
			}
			if (!(i == 0 || i == 1)) {
				
				xn = x0 + x1;
				x0 = x1;
				x1 = xn;
			}
			System.out.println(xn);
		}
		System.out.println("Fibonacci series for " + f + " >>>");
	}

}
