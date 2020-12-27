package com.amazon.coding;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* 

Example 1:

Input: nums = [3,1,2, 5, 3]
Output: [3, 4]
Explanation: n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the missing number in the range since it does not appear in nums.

 */

public class Arrays_RepeatAndMissingNumber {

	public static void main(String[] args) {
		int[] nums = new int[] { 3, 1, 2, 5, 3 };
		System.out.println(Arrays.toString(repeatAndMissingNumber(nums)));

		nums = new int[] { 1, 3, 4, 2, 2 };
		System.out.println(findDuplicate(nums));

	}

	public static int[] repeatAndMissingNumber(int[] nums) {
		return new int[] { Arrays.stream(nums).sum() - Arrays.stream(nums).distinct().sum(),
				(nums.length * (nums.length + 1) / 2) - Arrays.stream(nums).distinct().sum() };
	}

	public static int findDuplicate_Java8(int[] nums) {
		System.out.println(Arrays.stream(nums).sum());
		System.out.println(Arrays.stream(nums).distinct().sum());
		return (Arrays.stream(nums).sum() - Arrays.stream(nums).distinct().sum())
				/ (nums.length - (int) Arrays.stream(nums).distinct().count());
	}

	// O(n)
	public static int findDuplicate(int[] nums) {
		Set<Integer> set = new HashSet<>();
        for(int num : nums) {
            if (set.contains(num)) {
                return num;
            }
            set.add(num);
        }
        return -1;
	}
	
	// O(nlogn)
	public static int findDuplicate_BruteForce(int[] nums) {
		Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i-1]) {
                return nums[i];
            }
        }

        return -1;
	}

}
