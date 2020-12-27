package com.beginnerlevel.coding;

/*
Given an unsorted array A of size N of non-negative integers, find a continuous sub-array which adds to a given number S.

Input:
The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case consists of two lines. The first line of each test case is N and S, where N is the size of array and S is the sum. The second line of each test case contains N space separated integers denoting the array elements.

Output:
For each testcase, in a new line, print the starting and ending positions(1 indexing) of first such occuring subarray from the left if sum equals to subarray, else print -1.

Constraints:
1 <= T <= 100
1 <= N <= 107
1 <= Ai <= 1010

Example:
Input:
2
5 12
1 2 3 7 5
10 15
1 2 3 4 5 6 7 8 9 10
Output:
2 4
1 5

Explanation :
Testcase1: sum of elements from 2nd position to 4th position is 12
Testcase2: sum of elements from 1st position to 5th position is 15 
 */
public class SubarrayWithGivenSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("வணக்கம்");
		
		int[] arr1 = new int[] { 2, 1, 3, 7, 5 };
		int givenSum1 = 12;
		subarraySum(arr1, givenSum1);
		int[] arr2 = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int givenSum2 = 15;
		subarraySum(arr2, givenSum2);
	}

	private static void subarraySum(int[] arr, int givenSum) {
		int flag = -1;
		
		int sum = 0;
		for (int j = arr.length; j > 0; j--) {
			sum = 0;
			for (int i = arr.length - j; i < arr.length; i++) {
				if(flag == 1) break;
				System.out.println("int i "+i);
				System.out.println("arr[i] "+arr[i]);
				sum = arr[i] + sum;
				System.out.println("sum "+sum);
				if (givenSum == sum) {
					flag = 1;
					System.out.println(arr.length - j+1);
					System.out.println(i+1);
					break;
				}
			}
		}
		
		if(flag == -1)System.out.println(flag);

	}

}
