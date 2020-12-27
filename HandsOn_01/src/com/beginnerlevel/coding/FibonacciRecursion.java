package com.beginnerlevel.coding;

import java.util.Arrays;

public class FibonacciRecursion {

	public static void main(String[] args) {

		int n = 10;
		int[] arr = new int[n];
		fib(n, arr);
		System.out.println("F("+n+") is "+Arrays.toString(arr));
		System.out.print("F("+n+") is ");
		for(int i=1; i<n+1; i++) {
			System.out.print(fib(i));
			if(i != n) System.out.print(",");
		}
	}
	
	private static int fib(int n) {
		if(n < 1) return -1;
		else if (n == 1 || n == 2) return n-1;
		else {
			return fib(n-1) + fib(n-2);
		}
	}

	private static void fib(int n, int[] arr) {
		for (int i = 0; i < n; i++) {
			if (0 == i) {
				arr[i] = i;
			}
			else if (1 == i) {
				arr[i] = i;
			}
			else if (i > 1) {
				arr[i] = arr[i-2] + arr[i-1];
			}
		}
	}

}
