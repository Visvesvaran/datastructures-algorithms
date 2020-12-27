package com.beginnerlevel.coding;

import java.util.Arrays;

public class PlusOne {

	public static void main(String[] args) {
		int[] nums1 = new int[] { 2, 9 };
		int[] nums2 = new int[] { 9, 9 };
		System.out.println(Arrays.toString(plusOne(nums2)));
		int[] nums3 = new int[] { 8, 9, 9 };
		System.out.println(Arrays.toString(plusOne(nums3)));
	}

	public static int[] plusOne(int[] digits) {
		for (int i = digits.length - 1; i >= 0; i--) {
			if (digits[i] < 9) {
				digits[i] = digits[i] + 1;
				return digits;
			}
			digits[i] = 0;
		}

		int[] newDigit = new int[digits.length + 1];
		newDigit[0] = 1;
		return newDigit;
	}

	public static int[] plusOne_1(int[] digits) {
		if (digits.length == 1 && digits[0] < 9) {
			digits[0] = digits[0] + 1;
			return digits;
		} else {
			int i = digits.length - 1;
			while (i > -1) {
				if (digits[i] < 9) {
					digits[i] = digits[i] + 1;
					return digits;
				}
				digits[i] = 0;
				i--;
			}

			int[] newDigit = new int[digits.length + 1];
			newDigit[0] = 1;
			return newDigit;
		}
	}

	public static int[] process9(int[] digits) {
		int i = digits.length - 1;
		while (i > -1) {
			if (digits[i] < 9) {
				digits[i] = digits[i] + 1;
				return digits;
			}
			digits[i] = 0;
			i--;
		}

		int[] newDigit = new int[digits.length + 1];
		newDigit[0] = 1;
		return newDigit;
	}
}
