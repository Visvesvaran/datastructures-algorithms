package com.amazon.coding;

import java.util.HashMap;

class Node {
	int key;
	int value;
	TreeNode prev;
	TreeNode next;
	
	public Node(int key, int value) {
		this.key = key;
		this.value = value;
	}	
}

public class LRUCache {
	TreeNode head;
	TreeNode tail;
	HashMap<Integer, TreeNode> map = null;
	int cap = 0;
	
	public LRUCache(int c) {
		cap = c;
		map = new HashMap<Integer, TreeNode>();
	}
	
	public void put(int k, int v) {
		if(map.containsKey(k)) {
			map.get(k).value = v;
		} else {
			if(map.size()>=cap) {
				map.remove(tail.key);
				removeNode(tail);
			}
			TreeNode n = new TreeNode(k, v);
			map.put(k, n);
			putOnTop(n);
		}
	}
	
	public int get(int k) {
		if(map.containsKey(k)) {
			TreeNode n = map.get(k);
			removeNode(n);
			putOnTop(n);
			return n.value;
		}
		return -1;
	}
	
	private void removeNode(TreeNode node) {
		TreeNode prev = node.prev;
		TreeNode next = node.next;
		
		if(prev == null)
			head = next;
		else
			prev.next = node.next;
		if(next == null)
			tail = prev;
		else
			next.prev = prev;
	}
	
	private void putOnTop(TreeNode node) {
		node.next = head;
		node.prev = null;
		
		if(head!=null)
			head.prev = node;
		
		head = node;
		
		if(tail == null)
			tail = node;
	}
	
	public static void main(String[] args) {
		LRUCache cache = new LRUCache(3);
		
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

