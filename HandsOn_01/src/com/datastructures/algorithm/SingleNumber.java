package com.datastructures.algorithm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class SingleNumber {

	public static void main(String[] args) {
		// Math and Bit Manipulation FAILS when ONLY non-duplicate number exists Example:- [1,1,1]
		// Bit Manipulation FAILS when a particular number exists 3 times instead of 2 times Example:- [1,1,1,2].
		int[] nums = new int[] { 1,1,1,2 };
		singleNumber(nums);
		singleNumber_Math(nums);
		singleNumber_BitManipulation(nums);
	}

	public static int singleNumber_BitManipulation(int[] nums) {
		/*
		 * Concept
		 * 
		 * If we take XOR of zero and some bit, it will return that bit a \oplus 0 =
		 * aa⊕0=a If we take XOR of two same bits, it will return 0 a \oplus a = 0a⊕a=0
		 * a \oplus b \oplus a = (a \oplus a) \oplus b = 0 \oplus b =
		 * ba⊕b⊕a=(a⊕a)⊕b=0⊕b=b So we can XOR all bits together to find the unique
		 * number.
		 */
		int a = 0;
		for (int i : nums) {
			a ^= i;
			System.out.println(a);
		}
		return a;
	}

	public static int singleNumber_Math(int[] nums) {
		// Concept => 2 * (a + b + c) - (a + a + b + b + c) = c 2∗(a+b+c)−(a+a+b+b+c)=c

		int sumOfSet = 0, sumOfNums = 0;
		Set<Integer> set = new HashSet();

		for (int num : nums) {
			if (!set.contains(num)) {
				set.add(num);
				sumOfSet += num;
			}
			sumOfNums += num;
		}
		return 2 * sumOfSet - sumOfNums;
	}

	public static int singleNumber(int[] nums) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i : nums) {
			map.put(i, map.getOrDefault(i, 0) + 1);
		}

		for (int i : nums) {
			if (map.get(i) == 1) {
				return i;
			}
		}

		return 0;
	}

}
