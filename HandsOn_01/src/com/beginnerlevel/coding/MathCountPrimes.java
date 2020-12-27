package com.beginnerlevel.coding;

import java.util.ArrayList;
import java.util.List;

public class MathCountPrimes {

	public static void main(String[] args) {
		System.out.println(countPrimes(10));
		System.out.println(countPrimes(499979));
	}
	
	public static int countPrimes(int n) {		
		boolean[] prime = new boolean[n];
		for(int i=2;i<n;i++) {
			prime[i] = true;
		}
		for(int i=2;i*i<=n;i++) {
			if(!prime[i])
				continue;
			for(int j=i*i;j<n;j=j+i) {
				prime[j] = false;
			}
			
		}
		int count=0;
		for(int i=2;i<prime.length;i++) {
			if(prime[i])
				count++;
		}
		return count;
	}

	public static int countPrimes_2(int n) {
		int count = 0;
		for (int i = 1; i < n; i++) {
			if (isPrime(i))
				count++;
		}
		return count;
	}

	private static boolean isPrime(int num) {
		if (num <= 1)
			return false;
		// Loop's ending condition is i * i <= num instead of i <= sqrt(num)
		// to avoid repeatedly calling an expensive function sqrt().
		for (int i = 2; i * i <= num; i++) {
			if (num % i == 0)
				return false;
		}
		return true;
	}

	public static int countPrimes_1(int n) {
		if (n <= 2)
			return 0;
		if (n == 3)
			return 1;
		List<Integer> prime = new ArrayList<Integer>();
		prime.add(2);
		int i = 3;
		while (i < n) {
			for (int j = 0; j < prime.size(); j++) {
				if (i % prime.get(j) != 0) {
					if (j == prime.size() - 1) {
						prime.add(i);
					}
				} else {
					break;
				}
			}
			i++;
		}
		return prime.size();
	}

}
