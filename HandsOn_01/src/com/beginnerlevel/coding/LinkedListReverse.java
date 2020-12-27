package com.beginnerlevel.coding;

public class LinkedListReverse {

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
		reverseList(n1);
		// reverseList_Recursion(n1);
		// removeNthFromEnd(n7, 1);
		System.out.println(n6);
	}

	public static ListNode reverseList_Recursion(ListNode head) {
		return r(head, null);
	}

	/**
	 * @param temp
	 * @param prev
	 * @return
	 */
	// Recursive
	private static ListNode r(ListNode temp, ListNode prev) {
		ListNode nxt = null;
		if (temp != null) {
			nxt = temp.next;
			temp.next = prev;
			prev = temp;
			return r(nxt, prev);
		} else
			return prev;
	}

	// Recursive
	public static ListNode reverse_Recursive(ListNode head) {
		if (head == null || head.next == null)
			return head;

		/*
		 * reverse the rest list and put the first element at the end
		 */
		ListNode rest = reverse_Recursive(head.next);
		head.next.next = head;

		/* tricky step -- see the diagram */
		head.next = null;

		/* fix the head pointer */
		return rest;
	}

	public static ListNode reverseList(ListNode head) {
		if (head == null)
			return head;
		ListNode temp = head;
		ListNode prev = null;
		ListNode nxt = null;

		while (temp != null) {
			nxt = temp.next;
			temp.next = prev;
			prev = temp;
			temp = nxt;
		}
		return prev;
	}

	public static ListNode reverseList_1(ListNode head) {
		ListNode temp = new ListNode(0);
		temp.next = head;
		ListNode fast = temp;
		ListNode slowTemp = new ListNode(0);
		ListNode slow = new ListNode(0);
		slowTemp.next = slow;
		while (fast.next != null) {
			fast = fast.next;
			if (fast.next != null && fast.next.next == null) {
				slow.next = fast.next;
				fast.next = null;
				fast = temp;
				slow = slow.next;
			}
		}

		slow.next = fast;
		return slowTemp.next.next;
	}
}
