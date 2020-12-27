package com.beginnerlevel.coding;

import java.util.Arrays;

/*
 Given an array of distinct integers. The task is to count all the triplets such that sum of two elements equals the third element.

Input:
The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case consists of two lines. First line of each test case contains an Integer N denoting size of array and the second line contains N space separated elements.

Output:
For each test case, print the count of all triplets, in new line. If no such triplets can form, print "-1".

Constraints:
1 <= T <= 100
3 <= N <= 105
1 <= A[i] <= 106

Example:
Input:
2
4
1 5 3 2
3
3 2 7
Output:
2
-1

Explanation:
Testcase 1: There are 2 triplets: 1 + 2 = 3 and 3 +2 = 5
 */
public class CountTheTriplets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("வணக்கம்");

		int[] arr1 = new int[] { 1, 5, 3, 2 };
//		triplets(arr1);
		optimalTriplets(arr1);
	}

	private static void triplets(int[] arr) {
		int noOfTriplets = 0;
		int n = arr.length;
		for(int i=0; i<n; i++) {
			for(int j =i+1; j<n ; j++) {
				for( int k = j+1; k<n; k++) {
					if(arr[i]+arr[j]==arr[k] || arr[j]+arr[k]==arr[i] || arr[k]+arr[i]==arr[j]) {
						System.out.println("****************************");
						System.out.println(arr[i]+arr[j]);
						System.out.println(arr[k]+arr[j]);
						System.out.println(arr[i]+arr[k]);
						noOfTriplets++;
					}
				}
			}
		}
		System.out.println(noOfTriplets==0? -1: noOfTriplets);
	}
	
	private static void optimalTriplets(int[] arr) {
		int count = 0;
		
		Arrays.sort(arr);
		int n = arr.length;
		for(int i = 0; i < n; i++) {
			int lower = 0;
			int upper = i -1;
			while(lower<upper) {
				if(arr[i] == arr[lower]+arr[upper] || arr[lower] == arr[upper]+arr[i] || arr[upper] == arr[i]+arr[lower]) {
					System.out.println("****************************");
					System.out.println(arr[lower]+arr[upper]);
					System.out.println(arr[upper]+arr[i]);
					System.out.println(arr[i]+arr[lower]);
					count++;
					lower++;
					upper--;
				} else if (arr[i] < arr[lower] + arr[upper]) upper--;
				else lower++;
			}
		}
		
		System.out.println(count==0? -1: count);
	}

}
