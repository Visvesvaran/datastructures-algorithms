package com.datastructures.algorithm;

import java.util.Arrays;

public class TwoSum {

	/*
	 * Given nums = [2, 7, 11, 15], target = 9, Because nums[0] + nums[1] = 2 + 7 =
	 * 9, return [0, 1].
	 */
	public static int[] twoSum(int[] nums, int target) {

		System.out.println(">>> twoSum");

		int[] indices = null;

		for (int j = 0; j < nums.length; j++) {
			for (int i = 0; i < nums.length; i++) {
				if (j != i && target == nums[j] + nums[i]) {
					indices = new int[] { j, i };
					System.out.println(Arrays.toString(indices));
					return indices;
				}
			}
		}

		System.out.println("<<< twoSum");

		return indices;
	}

}
