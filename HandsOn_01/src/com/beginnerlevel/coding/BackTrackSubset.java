package com.beginnerlevel.coding;

import java.util.ArrayList;
import java.util.List;

/* 
 
 */

public class BackTrackSubset {

	public static void main(String[] args) {
		int[] nums = new int[] { 1, 2, 3 };
		System.out.println(subset(nums));
	}

	// Lexicographic (Binary Sorted) Subsets
	public static List<List<Integer>> subset(int[] nums) {
		List<List<Integer>> output = new ArrayList<List<Integer>>();
		int n = nums.length;

		for (int i = (int) Math.pow(2, n); i < (int) Math.pow(2, n + 1); ++i) {
			// generate bitmask, from 0..00 to 1..11
			String bitmask = Integer.toBinaryString(i).substring(1);

			// append subset corresponding to that bitmask
			List<Integer> curr = new ArrayList<Integer>();
			for (int j = 0; j < n; ++j) {
				if (bitmask.charAt(j) == '1')
					curr.add(nums[j]);
			}
			output.add(curr);
		}
		return output;
	}

	public static List<List<Integer>> subsetIterative(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		result.add(new ArrayList<Integer>());
		for (int n : nums) {
			int s = result.size();
			for (int i = 0; i < s; i++) {

				ArrayList<Integer> r = new ArrayList<Integer>(result.get(i));
				r.add(n);
				result.add(r);
			}
		}
		return result;
	}

	public static List<List<Integer>> subsetRecursive(int[] nums) {
		List<List<Integer>> lists = new ArrayList<List<Integer>>();
		if (nums == null || nums.length == 0) {
			lists.add(new ArrayList<Integer>());
			return lists;
		}
		generate(0, nums, new ArrayList<Integer>(), lists);
		return lists;
	}

	private static void generate(int index, int[] nums, List<Integer> list, List<List<Integer>> lists) {
		lists.add(new ArrayList<Integer>(list));
		for (int i = index; i < nums.length; i++) {
			list.add(nums[i]);
			generate(i + 1, nums, list, lists);
			list.remove(list.size() - 1);
		}
	}
}
