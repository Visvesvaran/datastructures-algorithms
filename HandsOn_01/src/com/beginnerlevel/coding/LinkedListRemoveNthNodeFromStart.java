package com.beginnerlevel.coding;

public class LinkedListRemoveNthNodeFromStart {

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

		removeNthFromStart(n1, 0);
//		removeNthFromEnd(n7, 1);
		System.out.println(n6);
	}

	public static ListNode removeNthFromStart(ListNode head, int n) {
		ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy;
        for(int i=1; i<n+1; i++) {
        	fast = fast.next;
        }
        
        fast.next = fast.next.next;
        return dummy.next;
	}
}
