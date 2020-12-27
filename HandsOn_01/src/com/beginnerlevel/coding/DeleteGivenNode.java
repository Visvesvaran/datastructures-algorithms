package com.beginnerlevel.coding;

public class DeleteGivenNode {

	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public static void main(String[] args) {
		ListNode n1 = new ListNode(4);
		ListNode n2 = new ListNode(5);
		n1.next = n2;
		ListNode n3 = new ListNode(1);
		n2.next = n3;
		ListNode n4 = new ListNode(9);
		n3.next = n4;
		deleteNode(n2);
		System.out.println(n1);
	}

	public static void deleteNode(ListNode node) {
		node.val = node.next.val;
		node.next = node.next.next;
	}
}
