package com.datastructures.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AddTwoNumbers {
	/*
	 * You are given two non-empty linked lists representing two non-negative
	 * integers. The digits are stored in reverse order and each of their nodes
	 * contain a single digit. Add the two numbers and return it as a linked list.
	 * You may assume the two numbers do not contain any leading zero, except the
	 * number 0 itself. Example: Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) Output: 7 -> 0
	 * -> 8 Explanation: 342 + 465 = 807.
	 */

	public static int addTwoNumbers(ListNode l1, ListNode l2) {

		return (reverseNumber(l1) + reverseNumber(l2));

	}
	
	public static int reverseNumber(ListNode l) {
		
		int actualNum = l.val;
		int reversedNum = 0;
		
		List<Integer> d1 = new ArrayList<Integer>();
		
		while (actualNum > 0) {
			d1.add(actualNum % 10);
			actualNum = actualNum / 10;
		}

		int pow = 0;
		for (int i = 0; i < d1.size(); i++) {
			pow = (int) Math.pow(10, new Double(d1.size() - 1 - i));
			reversedNum = reversedNum + d1.get(i) * pow;
		}
		
		return reversedNum;
	}
}
