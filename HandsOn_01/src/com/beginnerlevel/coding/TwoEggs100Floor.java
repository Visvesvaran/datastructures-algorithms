package com.beginnerlevel.coding;

public class TwoEggs100Floor {

	// Java program to find minimum 
	// number of trials in worst case. 
	// Find sum of binomial coefficients xCi 
	// (where i varies from 1 to n). If the sum 
	// becomes more than K 
	static int binomialCoeff(int x, int n, int k) 
	{ 
		int sum = 0, term = 1; 
		for (int i = 1; i <= n && sum < k; ++i) { 
			term *= x - i + 1; 
			term /= i; 
			sum += term; 
		} 
		return sum; 
	} 

	// Do binary search to find minimum 
	// number of trials in worst case. 
	static int minTrials(int n, int k) 
	{ 
		// Initialize low and high as 1st 
		//and last floors 
		int low = 1, high = k; 

		// Do binary search, for every mid, 
		// find sum of binomial coefficients and 
		// check if the sum is greater than k or not. 
		while (low < high) { 
			int mid = (low + high) / 2; 
			if (binomialCoeff(mid, n, k) < k) 
				low = mid + 1; 
			else
				high = mid; 
		} 

		return low; 
	} 

	/* Driver program to test above function*/
	public static void main(String args[]) 
	{ 
		System.out.println(minTrials(2, 100)); 
	} 

}
