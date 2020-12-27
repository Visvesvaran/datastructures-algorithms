package com.amazon.coding;

import java.util.HashMap;

class TreeNode {
	int key;
	int value;
	TreeNode prev;
	TreeNode next;

	public TreeNode(int key, int value) {
		this.key = key;
		this.value = value;
	}
}

public class LRUCache1 {
	TreeNode head;
	TreeNode tail;
	HashMap<Integer, TreeNode> map = null;
	int cap;

	public LRUCache1(int cap) {
		map = new HashMap<>();
		this.cap = cap;
	}

	public void put(int key, int value) {
		if (map.containsKey(key)) {
			map.get(key).value = value;
		} else {
			if(map.size()>=cap) {
				map.remove(tail.key);
				remove(tail);
			}
			TreeNode n = new TreeNode(key, value);
			map.put(key, n);
			putOnTop(n);
		}
	}

	public int get(int key) {
		if(map.containsKey(key)) {
			TreeNode n = map.get(key);
			remove(n);
			putOnTop(n);
			return n.value;
		}
		return -1;
	}
	
	private void remove(TreeNode n) {
		TreeNode prev = n.prev;
		TreeNode next = n.next;
		
		if(prev == null)
			head = next;
		else
			prev.next = n.next;
		
		if(next == null)
			tail = prev;
		else
			next.prev = prev;
	}
	
	private void putOnTop(TreeNode n) {
		n.prev = null;
		n.next = head;
		
		if(head!=null)
			head.prev = n;
		
		head = n;
		
		if(tail == null)
			tail = n;
	}
	
	public static void main(String[] args) {
		LRUCache1 cache = new LRUCache1(3);
		
		cache.put(1, 3);
		cache.put(4, 2);
		
		System.out.println(cache.get(1)); 
		
		cache.put(5, 6);
		System.out.println(cache.get(7)); 
		System.out.println(cache.get(5)); 
		
		cache.put(7, 4);
		System.out.println(cache.get(4));
		
		System.out.println(cache.get(1)); 
		System.out.println(cache.get(5)); 
		System.out.println(cache.get(7)); 
		
	}
}
