package com.beginnerlevel.coding;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/* 
You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. The binary tree has the following definition:

Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

 

Follow up:

You may only use constant extra space.
Recursive approach is fine, you may assume implicit stack space does not count as extra space for this problem.
 

Example 1:
Input: root = [1,2,3,4,5,6,7]
Output: [1,#,2,3,#,4,5,6,7,#]
Explanation: Given the above perfect binary tree (Figure A), your function should populate each next pointer to point to its next right node, just like in Figure B. The serialized output is in level order as connected by the next pointers, with '#' signifying the end of each level.

// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};

class Solution {
    public Node connect(Node root) {
 */

public class SortTopKFrequentElement {

	public static class Node {
	    public int val;
	    public Node left;
	    public Node right;
	    public Node next;

	    public Node() {}
	    
	    public Node(int _val) {
	        val = _val;
	    }

	    public Node(int _val, Node _left, Node _right, Node _next) {
	        val = _val;
	        left = _left;
	        right = _right;
	        next = _next;
	    }
	};

	public static void main(String[] args) {
		Node t1 = new Node(1);
		Node t2 = new Node(2);
		Node t3 = new Node(3);
		t1.left = t2;
		t1.right = t3;
		Node t4 = new Node(4);
		Node t5 = new Node(5);
		t2.left = t4;
		t2.right = t5;
		Node t6 = new Node(6);
		Node t7 = new Node(7);
		t3.left = t6;
		t3.right = t7;
		System.out.println(connect(t1));
	}
	public static Node connect(Node root) {
        if (root == null) {
            return null;
        }
        execute(root);
        return root;
    }
	
	public static void execute(Node node) {
        Node leftNode = node.left;
        Node rightNode = node.right;
        while (leftNode != null && rightNode != null) {
            leftNode.next = rightNode;
            leftNode = leftNode.right;
            rightNode = rightNode.left;
        }
        if (node.left != null) {
            execute(node.left);
        }
        if (node.right != null) {
            execute(node.right);
        }
    }
	public static Node connectIterative(Node root) {
		if (root == null)
			return root;
		Queue<Node> q = new LinkedList<Node>();
		q.offer(root);
		int d = findDepth(root);
		int h = 0;
		while (h < d) {
			int size = q.size();
			Node prev = null;
			while (size > 0) {
				Node n = q.poll();
				if (n.left != null)
					q.offer(n.left);
				if (n.right != null)
					q.offer(n.right);
				if(prev!=null)
					prev.next = n;
				prev = n;
				size--;
			}
			h++;
		}
		return root;
	}
	
	public static List<List<Integer>> levelOrder_1(Node root) {
		int height = findDepth(root);
		List<List<Integer>> levelOrderList = new ArrayList<List<Integer>>();
		for (int i = 1; i < height + 1; i++) {
			List<Integer> levelList = new ArrayList<Integer>();
			levelOrderHelper(root, i, levelList);
			if (!levelList.isEmpty()) {
				levelOrderList.add(levelList);
			}
		}
		return levelOrderList;
	}

	public static void levelOrderHelper(Node node, int level, List<Integer> levelList) {
		if (node == null) {
			return;
		}

		if (level == 1) {
			levelList.add(node.val);
		} else {
			levelOrderHelper(node.left, level - 1, levelList);
			levelOrderHelper(node.right, level - 1, levelList);
		}
	}

	private static int findDepth(Node root) {
		if (root == null)
			return 0;
		int l = findDepth(root.left);
		int r = findDepth(root.right);
		return Math.max(l, r) + 1;
	}

}
