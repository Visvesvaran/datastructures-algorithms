package com.beginnerlevel.coding;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import com.beginnerlevel.coding.Tree_LevelOrderTraversal.TreeNode;

public class Tree_LevelOrderTraversal {

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
		TreeNode t1 = new TreeNode(3);
		TreeNode t2 = new TreeNode(9);
		TreeNode t3 = new TreeNode(20);
		t1.left = t2;
		t1.right = t3;
		// TreeNode t4 = new TreeNode(4);
		// TreeNode t5 = new TreeNode(5);
		// t2.left = t4;
		// t2.right = t5;
		TreeNode t6 = new TreeNode(15);
		TreeNode t7 = new TreeNode(7);
		t3.left = t6;
		t3.right = t7;
		System.out.println(zigzagLevelOrder(t1));
		t1 = new TreeNode(1);
		t2 = new TreeNode(2);
		t3 = new TreeNode(3);
		t1.left = t2;
		t1.right = t3;
		TreeNode t4 = new TreeNode(4);
		t2.left = t4;
		t7 = new TreeNode(5);
		t3.right = t7;
		System.out.println(zigzagLevelOrder(t1));
		// levelOrder(t1);
		// levelOrder_1(t1);
		/*
		 * Depth First Traversals: (a) Inorder (Left, Root, Right) : 4 2 5 1 3 (b)
		 * Preorder (Root, Left, Right) : 1 2 4 5 3 (c) Postorder (Left, Right, Root) :
		 * 4 5 2 3 1
		 */

		// System.out.println("Preorder (Root, Left, Right)");
		// preOrder_1(t1);
		// System.out.println(" ");
		// System.out.println("Inorder (Left, Root, Right)");
		// inOrder_1(t1);
		// System.out.println(" ");
		// System.out.println("Postorder (Left, Right, Root)");
		// postOrder_1(t1);
		// System.out.println(" ");
	}

	public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> lists = new ArrayList();
		if (root == null)
			return lists;
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.offer(root);
		int d = maxDepth(root);
		int h = 0;
		boolean l2r = true;
		while (h < d) {
			List<Integer> list = new ArrayList();
			int size = q.size();
			while (size > 0) {
				TreeNode n = q.poll();
                if(l2r)
				    list.add(n.val);
                else
                    list.add(0,n.val);
				if (n.left != null)
					q.offer(n.left);
				if (n.right != null)
					q.offer(n.right);
				size--;
			}
			if (!list.isEmpty()) {
				lists.add(list);
                l2r = !l2r;
			}
			h++;
		}
		return lists;
	}

	public static List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> levelOrderList = new ArrayList<List<Integer>>();
		if (root == null) {
			return levelOrderList;
		}
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		while (!q.isEmpty()) {
			int size = q.size();
			List<Integer> list = new ArrayList<Integer>();
			while (size > 0) {
				TreeNode node = q.poll();

				list.add(node.val);
				if (node.left != null) {
					q.add(node.left);
				}
				if (node.right != null) {
					q.add(node.right);
				}

				size--;
			}
			levelOrderList.add(list);
		}
		return levelOrderList;
	}

	public static List<List<Integer>> levelOrder_1(TreeNode root) {
		int height = maxDepth(root);
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

	public static void levelOrderHelper(TreeNode node, int level, List<Integer> levelList) {
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

	public static int maxDepth(TreeNode node) {
		if (node == null) {
			return 0;
		} else {
			int leftDepth = maxDepth(node.left);
			int rightDepth = maxDepth(node.right);
			if (leftDepth > rightDepth) {
				return leftDepth + 1;
			} else {
				return rightDepth + 1;
			}
		}
	}

	// Preorder (Root, Left, Right)
	public static void preOrder_1(TreeNode node) {
		if (node == null) {
			return;
		}
		System.out.print(node.val);
		preOrder_1(node.left);
		preOrder_1(node.right);
	}

	// Inorder (Left, Root, Right)
	public static void inOrder_1(TreeNode node) {
		if (node == null) {
			return;
		}
		inOrder_1(node.left);
		System.out.print(node.val);
		inOrder_1(node.right);
	}

	// Postorder (Left, Right, Root)
	public static void postOrder_1(TreeNode node) {
		if (node == null) {
			return;
		}
		postOrder_1(node.left);
		postOrder_1(node.right);
		System.out.print(node.val);
	}
}