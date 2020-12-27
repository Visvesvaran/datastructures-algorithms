package com.beginnerlevel.coding;

import java.util.Arrays;

/*//Given an array of integers, return indices of the two numbers such that they add up to a specific target.
//
//You may assume that each input would have exactly one solution, and you may not use the same element twice.
//
//Example:
//
//Given nums = [2, 7, 11, 15], target = 9,
//
//Because nums[0] + nums[1] = 2 + 7 = 9,
//return [0, 1].
*/
public class TwoSum_01_BruteForce {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] a = new int[] {2,7,11,15};
		int target = 9;
		
		twoSum(a, target);

	}
    public static int[] twoSum(int[] a, int target) {
        int[] indices = null;
		for (int i = 0; i < a.length; i++) {
			for (int j = i+1; j < a.length; j++) {
				if(a[j] == target - a[i]) {
					indices = new int[] {i,j};
					System.out.println(Arrays.toString(indices));
					return indices;
				}
			}
		}
		return indices;
    }

}
