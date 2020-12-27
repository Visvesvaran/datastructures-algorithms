package com.beginnerlevel.coding;

import java.util.Arrays;

/*
Given an array, rotate the array to the right by k steps, where k is non-negative.

Follow up:

Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
Could you do it in-place with O(1) extra space?
 

Example 1:

Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]
Example 2:

Input: nums = [-1,-100,3,99], k = 2
Output: [3,99,-1,-100]
Explanation: 
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]
 

Constraints:

1 <= nums.length <= 2 * 10^4
It's guaranteed that nums[i] fits in a 32 bit-signed integer.
k >= 0 
 */
public class RotateArrays {

	public static void main(String[] args) {
		int[] nums = new int[] {1,2,3,4,5,6,7};
		int k = 3;
		rotate1(nums, k);
		int last = nums.length-1;
		int previousToLast = last-1;
		
		while(k>0) {
			int lastElement = nums[last];
			rotate(nums, lastElement, last, previousToLast);
			k--;
			System.out.println("rotate " + k + " steps to the right: "+Arrays.toString(nums));
		}
		
		System.out.println(Arrays.toString(nums));
		
		nums = new int[] {-1,-100,3,99};
		k = 2;
		last = nums.length-1;
		previousToLast = last-1;
		while(k>0) {
			int lastElement = nums[last];
			rotate(nums, lastElement, last, previousToLast);
			k--;
			System.out.println("rotate " + k + " steps to the right: "+Arrays.toString(nums));
		}
		System.out.println(Arrays.toString(nums));

	}
	
	private static void rotate1(int[] nums, int k) {
	    int[] a = new int[nums.length];
	    for (int i = 0; i < nums.length; i++) {
	      a[(i + k) % nums.length] = nums[i];
	    }
	    for (int i = 0; i < nums.length; i++) {
	      nums[i] = a[i];
	    }
	  }
	
	private static void rotate(int[] nums, int lastElement, int last, int previousToLast) {
		if(last == 0) {
			nums[last] = lastElement;
//			System.out.println(Arrays.toString(nums));
		} else {
			nums[last] = nums[previousToLast];
			last--;
			previousToLast--;
//			System.out.println(Arrays.toString(nums));
			rotate(nums, lastElement, last, previousToLast);
		}		
	}

}
