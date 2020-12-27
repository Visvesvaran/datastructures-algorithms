package com.beginnerlevel.coding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/* 
 
 */

public class BackTrackPermutations {

	public static void main(String[] args) {
		int[] nums = new int[] { 1, 2, 3 };
		System.out.println(permute(nums));
	}

	public static List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> lists = new ArrayList<List<Integer>>();
		List<Integer> list = new ArrayList<Integer>();
		if (nums == null || nums.length == 0) {
			lists.add(list);
			return lists;
		}
		boolean[] used = new boolean[nums.length];
		generate(nums, used, list, lists);
		return lists;
	}

	private static void generate(int[] nums, boolean[] used, List<Integer> list, List<List<Integer>> lists) {
		if (list.size() == nums.length) {
			lists.add(new ArrayList<Integer>(list));
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			if (used[i])
				continue;
			list.add(nums[i]);
			used[i] = true;
			generate(nums, used, list, lists);
			list.remove(list.size() - 1);
			used[i] = false;
		}
	}

	static List<List<Integer>> result = new ArrayList<>();

	public static List<List<Integer>> permute_1(int[] nums) {
		process(nums, 0);
		return result;
	}

	static void process(int[] nums, int start) {
		if (start == nums.length) {
			List<Integer> list = new ArrayList<>();
			for (int x : nums) {
				list.add(x);
			}
			result.add(list);
			return;
		}

		for (int i = start; i < nums.length; i++) {
			swap(nums, i, start);
			process(nums, start + 1);
			swap(nums, i, start);
		}
	}

	static void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}

}
