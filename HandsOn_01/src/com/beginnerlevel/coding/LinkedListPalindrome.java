package com.beginnerlevel.coding;

import com.beginnerlevel.coding.LinkedListReverse.ListNode;

public class LinkedListPalindrome {

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
		ListNode n9 = new ListNode(2);
		n8.next = n9;
		ListNode n10 = new ListNode(1);
		n9.next = n10;

		isPalindrome(n7);
		// removeNthFromEnd(n7, 1);
		System.out.println(n6);
	}
	
	public static boolean isPalindrome(ListNode head) {
		ListNode cur = head;
        int count = 0;
        while(cur != null) {
            count++;
            cur = cur.next;
        }
        // reverse list from 0 to center
        ListNode left = null;
        cur = head;
        for(int i = 0; i < count / 2; i++) {
            ListNode nextTemp = cur.next;
            cur.next = left;
            left = cur;
            cur = nextTemp;
        }
        // if the size of list is odd, skip middle 
        if( (count & 1) == 1 ) cur = cur.next;
        
        // compare left and right
        ListNode right = cur;
        while(left != null && right != null) {
            if(left.val != right.val) return false;
            left = left.next;
            right = right.next;
        }
        // check if we have check the list until the end
        if(left == null && right == null) return true;
        return false; 
	}

	public static boolean isPalindrome_2(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		ListNode pre = null;
		ListNode temp = slow;
		while (slow != null) {
			temp = slow.next;
			slow.next = pre;
			pre = slow;
			slow = temp;
		}

		while (pre != null) {
			if (pre.val != head.val) {
				return false;
			}
			pre = pre.next;
			head = head.next;
		}
		return true;
	}

	public static boolean isPalindrome_1(ListNode head) {
		if (head == null || head.next == null)
			return true;
		if (head.next != null && head.next.next == null && head.val == head.next.val)
			return true;

		ListNode temp = new ListNode(0);
		temp.next = head;
		ListNode fast = temp;
		ListNode slow = temp;
		slow = slow.next;
		fast = slow.next;
		while (slow.next != null) {
			ListNode prev = null;
			while (fast.next != null) {
				prev = fast;
				fast = fast.next;
			}
			if (slow.val != fast.val)
				return false;
			slow = slow.next;
			prev.next = null;
			fast = slow;
		}

		return true;
	}

}
