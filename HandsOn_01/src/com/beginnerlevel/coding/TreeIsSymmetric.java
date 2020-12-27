package com.beginnerlevel.coding;

import java.util.LinkedList;
import java.util.Stack;

import com.beginnerlevel.coding.TreeIsSymmetric.TreeNode;

public class TreeIsSymmetric {

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
		TreeNode t3 = new TreeNode(2);
		t1.left = t2;
		t1.right = t3;
		TreeNode t4 = new TreeNode(2);
		TreeNode t5 = new TreeNode(4);
		t2.left = t4;
		// t2.right = t5;
		TreeNode t6 = new TreeNode(2);
		TreeNode t7 = new TreeNode(3);
		t3.left = t6;
		// t3.right = t7;

		/*
		 * Depth First Traversals: (a) Inorder (Left, Root, Right) : 4 2 5 1 3 (b)
		 * Preorder (Root, Left, Right) : 1 2 4 5 3 (c) Postorder (Left, Right, Root) :
		 * 4 5 2 3 1
		 */

		System.out.println(isSymmetric(t1.left, t1.right));
		System.out.println("Preorder (Root, Left, Right)");
		preOrder_1(t1);
		System.out.println(" ");
		System.out.println("Inorder (Left, Root, Right)");
		inOrder_1(t1);
		System.out.println(" ");
		System.out.println("Postorder (Left, Right, Root)");
		postOrder_1(t1);
		System.out.println(" ");
	}

	public static boolean isSymmetric(TreeNode l, TreeNode r) {
		if (l == null)
			return r == null;

		if (r == null)
			return l == null;

		if (l.val != r.val)
			return false;
		
		return isSymmetric(l.left, r.right) && isSymmetric(l.right, r.left);

	}

	public static boolean isSymmetric_1(TreeNode l, TreeNode r) {
		if (l == null && r != null)
			return false;

		if (l != null && r == null)
			return false;

		if (l != null && r != null) {
			if (l.val != r.val)
				return false;
			if (!isSymmetric(l.left, r.right))
				return false;
			if (!isSymmetric(l.right, r.left))
				return false;
		}

		return true;
	}

	// Preorder (Root, Left, Right)
	public static void preOrder_1(TreeNode node) {
		if (node == null) {
			System.out.print("0");
			return;
		}
		System.out.print(node.val);
		preOrder_1(node.left);
		preOrder_1(node.right);
	}

	// Inorder (Left, Root, Right)
	public static void inOrder_1(TreeNode node) {
		if (node == null) {
			System.out.print("0");
			return;
		}
		inOrder_1(node.left);
		System.out.print(node.val);
		inOrder_1(node.right);
	}

	// Postorder (Left, Right, Root)
	public static void postOrder_1(TreeNode node) {
		if (node == null) {
			System.out.print("0");
			return;
		}
		postOrder_1(node.left);
		postOrder_1(node.right);
		System.out.print(node.val);
	}
}