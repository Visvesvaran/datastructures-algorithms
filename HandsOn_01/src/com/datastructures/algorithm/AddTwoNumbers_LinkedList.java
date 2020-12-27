package com.datastructures.algorithm;

import com.datastructures.algorithm.AddTwoNumbers_LinkedList.ListNode;

/*
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example:

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class AddTwoNumbers_LinkedList {
	
	static ListNode l1, l2;

	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public static void main(String[] args) {
		int n1,n2,sum;
		
		int i = 2; int j = 4; int k = 3;
		l1 = setLinkedList(i, j, k);
		
		i = 5; j = 6; k = 4;
		l2 = setLinkedList(i, j, k);
		
		addTwoNumbers(l1, l2);
		
	}
	
	private static ListNode setLinkedList(int i, int j, int k) {
		ListNode l1 = new ListNode(i);
		ListNode l2 = new ListNode(j);
		ListNode l3 = new ListNode(k);
		
		l1.next = l2;
		l2.next = l3;
		return l1;
	}
	
	private static int addTwoNumbers(ListNode l12, ListNode l22) {
		int n1, n2,sum;
		n1 = reverse(l12);
		n2 = reverse(l22);
		sum = n1 + n2;
		System.out.println(sum);
		return sum;
	}
	private static int reverse(ListNode l) {
		StringBuilder sb = new StringBuilder();
		while(null != l) {
			System.out.println(l.val);
			sb.append(l.val);
			l = l.next;
		}
		return Integer.valueOf(sb.reverse().toString());
	}

}
