package com.beginnerlevel.coding;

public class RotateArrayEasy {
	
	public void rotate_1(int[] nums, int k) {
		
		System.out.println(" k = k % nums.length;>>> "+ k % nums.length);
		k = k % nums.length;
		int[] temp = new int[nums.length];
		for(int i = 0; i < nums.length; i++) {
			temp[(i+k)%nums.length] = nums[i];
		}
		for(int i = 0; i < nums.length; i++) {
			nums[i] = temp[i];
		}
	}
			
	public void rotate(int[] nums, int k) {

		// Input: nums = [1,2,3,4,5,6,7], k = 3
		// Output: [5,6,7,1,2,3,4]
		// Explanation:
		// rotate 1 steps to the right: [7,1,2,3,4,5,6]
		// rotate 2 steps to the right: [6,7,1,2,3,4,5]
		// rotate 3 steps to the right: [5,6,7,1,2,3,4]
		while (k < 3) {
			int l = nums.length - 1;
			int temp = nums[l];
			for (int i = l; i > 0; i--) {
				nums[i] = nums[i - 1];
			}
			nums[0] = temp;
			k++;
		}
	}
}
