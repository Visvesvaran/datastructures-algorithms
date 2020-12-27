package com.beginnerlevel.coding;

public class LinkedListMerge {

	public static class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int x) {
			val = x;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		n1.next = n2;
		ListNode n3 = new ListNode(3);
		n2.next = n3;
		ListNode n4 = new ListNode(4);
		n3.next = n4;
		ListNode n5 = new ListNode(5);
		n4.next = n5;

		ListNode n6 = new ListNode(1);

		ListNode n7 = new ListNode(1);
		ListNode n8 = new ListNode(2);
		n7.next = n8;

		mergeList(n1, n7);
		// removeNthFromEnd(n7, 1);
		System.out.println(n6);
	}

	public static ListNode mergeList(ListNode l1, ListNode l2) {
		ListNode temp = new ListNode(0);
		ListNode pointer = temp;
		while (l1 != null && l2 != null) {
			if (l1.val <= l2.val) {
				pointer.next = l1;
				l1 = l1.next;
			} else {
				pointer.next = l2;
				l2 = l2.next;
			}
			pointer = pointer.next;
			pointer.next = null;
		}

		while (l1 != null) {
			pointer.next = l1;
			l1 = l1.next;
			pointer = pointer.next;
			pointer.next = null;
		}

		while (l2 != null) {
			pointer.next = l2;
			l2 = l2.next;
			pointer = pointer.next;
			pointer.next = null;
		}
		return temp.next;
	}
}
