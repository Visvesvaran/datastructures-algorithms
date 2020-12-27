
package com.beginnerlevel.coding;

public class LinkedListRemoveNthNodeFromEnd {

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

		removeNthFromEnd_2(n1, 2);
		removeNthFromEnd(n7, 1);
		System.out.println(n6);
	}

	public static ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        while(n != 0 && fast.next != null) {
            fast = fast.next;
            n--;
        }
        while(fast != null && fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
	}
	
	public static ListNode removeNthFromEnd_2(ListNode head, int n) {
		ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        for(int i=1; i<n+1; i++) {
        	fast = fast.next;
        }
        
        while(fast != null && fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
	}
	public static ListNode removeNthFromEnd_1(ListNode head, int n) {
		if (n == 1 && head.next == null) return head.next;
        if (n == 1 && head.next != null && head.next.next == null){
            head.next = head.next.next;
            return head;  
        } 
		ListNode d2 = new ListNode();
        int j = 1;
        d2.val = head.val;
        d2.next = head.next;
        while(d2.next!=null) {
        	d2.val = d2.next.val;
        	d2.next = d2.next.next;
        	j++;
        }
        if (j == n && d2.next == null) {
			head.val = head.next.val;
			head.next = head.next.next;
		}
        if(head.next != null) removeNthFromEnd(head.next, n);   
        return head;
	}
}
