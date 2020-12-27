package com.beginnerlevel.coding;

public class fibonacci_inprogress1 {

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
			if(i == 0 || i == 1) {
				xn = i;
			}else {
				xn = xn + x1;
				x1 = xn;
			}
			System.out.println(xn);
		}
		System.out.println("Fibonacci series for " + f + " >>>");
	}

}
