package com.datastructures.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Intersection {

	public static void main(String[] args) {
		int[] nums1 = new int[] { 1, 2 };
		int[] nums2 = new int[] { 2, 1 };
		intersect(nums1, nums2);

	}

	public static int[] intersect(int[] nums1, int[] nums2) {

		HashMap<Integer, Integer> map1 = new HashMap<>();
		
		HashMap<Integer, Integer> map2 = new HashMap<>();

		for (int i : nums1) {
			map1.put(i, map1.getOrDefault(i, 0) + 1);
		}

		for (int i : nums2) {
			if (map1.containsKey(i)) {
				map2.put(i, map2.getOrDefault(i, 0) + 1);
			}
		}

		List<Integer> listResult = new ArrayList<Integer>();
		for (int i : nums2) {
			int j = 1;
			if (map2.containsKey(i) && map2.get(i) > 0) {
				if(!listResult.contains(i)) {
				listResult.add(i);
				} else if(listResult.contains(i) && map2.get(i) > j) {
					listResult.add(i);
					j++;
				}
			}
		}

		int[] result = new int[listResult.size()];
		int i = 0;
		for (int num : listResult) {
			result[i++] = num;
		}
		return result;

	}

}
