package com.beginnerlevel.coding;

import java.util.LinkedList;
import java.util.Stack;

import com.beginnerlevel.coding.TreeValidBST.TreeNode;

public class TreeValidBST {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		t1.left = t2;
		t1.right = t3;
		TreeNode t4 = new TreeNode(4);
		;
		TreeNode t5 = new TreeNode(5);
		;
		t2.left = t4;
		t2.right = t5;
		// TreeNode t6 = new TreeNode(6);
		// TreeNode t7 = new TreeNode(7);
		// t3.left = t6;
		// t3.right = t7;
		System.out.println(inOrder(t1));

		System.out.println(isValidBST(t1));

		t1 = new TreeNode(5);
		t2 = new TreeNode(1);
		t3 = new TreeNode(6);
		t1.left = t2;
		t1.right = t3;
		// TreeNode t4 = null;
		// TreeNode t5 = null;
		// t2.left = t4;
		// t2.right = t5;
		TreeNode t6 = new TreeNode(4);
		TreeNode t7 = new TreeNode(7);
		t3.left = t6;
		t3.right = t7;

		System.out.println(isValidBST(t1));

		t6 = new TreeNode(0);
		t7 = new TreeNode(-1);
		t6.left = t7;

		System.out.println(isValidBST(t6));
	}

	public static boolean inOrder(TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
	    double inorder = - Double.MAX_VALUE;

	    while (!stack.isEmpty() || root != null) {
	      while (root != null) {
	        stack.push(root);
	        root = root.left;
	      }
	      root = stack.pop();
	      // If next element in inorder traversal
	      // is smaller than the previous one
	      // that's not BST.
	      if (root.val <= inorder) return false;
	      inorder = root.val;
	      root = root.right;
	    }
	    return true;
	}

	public static void inOrder_1(TreeNode node) {
		if (node == null)
			return;
		inOrder_1(node.left);
		System.out.println(node.val);
		inOrder_1(node.right);
	}

	static LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
	static LinkedList<Integer> uppers = new LinkedList<Integer>();
	static LinkedList<Integer> lowers = new LinkedList<Integer>();

	public static void update(TreeNode root, Integer lower, Integer upper) {
		stack.add(root);
		lowers.add(lower);
		uppers.add(upper);
	}

	public static boolean isValidBST(TreeNode root) {
		Integer lower = null, upper = null, val;
		update(root, lower, upper);

		while (!stack.isEmpty()) {
			root = stack.poll();
			lower = lowers.poll();
			upper = uppers.poll();

			if (root == null)
				continue;
			val = root.val;
			if (lower != null && val <= lower)
				return false;
			if (upper != null && val >= upper)
				return false;
			update(root.right, val, upper);
			update(root.left, lower, val);
		}
		return true;
	}

	public static boolean isValidBST_Recursion(TreeNode root) {

		return loop(root, null, null);
	}

	public static boolean loop(TreeNode node, Integer lower, Integer upper) {
		if (node == null)
			return true;
		int val = node.val;
		if (lower != null && val <= lower)
			return false;
		if (upper != null && val >= upper)
			return false;
		if (!loop(node.right, val, upper))
			return false;
		if (!loop(node.left, lower, val))
			return false;
		return true;
	}
}