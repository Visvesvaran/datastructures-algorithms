package com.datastructures.algorithm;

public class Main {
	private static int search = 0;
	private static int[] x;
	

	public static void main(String[] args) {
		// oneDimensionalArray
		search = 6;
		x = new int[] {1,4,3,2,6};
		// time complexity O(n)
		LinearSearch.oneDimensionalArray(search, x);
		
		// binary search
		search = 23;
		x = new int[] {2,5,8,12,16,23,38,56,72,91,1000};
		// time complexity O(log n to the base 2)
		BinarySearch.binary(search, x);
		
		// bubble sort
		x = new int[] {9,8,7,6,5,4,3,2,1};
		x = new int[] {1,2,3,4,5,6,7,8,9};
		x = new int[] {11,1,2,0,3,4,5,96, 6,7,8,9, 50, 100};
		x = new int[] {11,1,2,0,3,4,5,96, 6,7,8,9, 50, 100, -4,-1};
		BubbleSort.bubbleSort(x);
		
		//n smallest
		x = new int[] {2, 7, 11, 15};
		int target = 9;
		TwoSum.twoSum(x, target);
		
		target = 18;
		TwoSum.twoSum(x, target);
		
		// Add Two Numbers
		ListNode l1 = new ListNode(243);
		ListNode l2 = new ListNode(564);
		System.out.println(AddTwoNumbers.addTwoNumbers(l1, l2));
		
	}

}
