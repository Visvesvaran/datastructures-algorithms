package com.beginnerlevel.coding;

/*
Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

Preorder (Root, Left, Right)
preorder = [3,9,20,15,7]

Inorder (Left, Root, Right)
inorder = [9,3,15,20,7]

Preorder (Root, Left, Right)
124005003600700 
Inorder (Left, Root, Right)
040205010603070 

Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7
   
    1
   / \
  2    3
 / \  /  \
4  5  6   7
   
Algo
 * get the root and 1st left node from preorder
 * find the index of left node in inorder
 	* index could be 0th position - it means left node does not have child nodes
 	* index could be greater than 0	- it means left node has child nodes
* find the index of root node in inorder
* construct left sub tree until root node index
* make left subtree as root left
* get last node value of left subtree
* find the index of last node value in preorder. the node next to his index is right node
* find the index of this right node in inorder
 	* index could be 0th position - it means left node does not have child nodes
 	* index could be greater than 0	- it means left node has child nodes
* construct right sub tree
* make right subtree as root right
 * */
public class ConstructTree {

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
		int[] pre = new int[] { 1, 2, 4, 5, 3, 6, 7 };
		int[] in = new int[] { 4, 2, 5, 1, 6, 3, 7 };
		System.out.println("Preorder (Root, Left, Right)");
		preOrder_1(constructNodes(pre, in));
		System.out.println(" ");
		System.out.println("Inorder (Left, Root, Right)");
		inOrder_1(constructNodes(pre, in));
		System.out.println(" ");
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		t1.left = t2;
		t1.right = t3;
		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(5);
		t2.left = t4;
		t2.right = t5;
		TreeNode t6 = new TreeNode(6);
		TreeNode t7 = new TreeNode(7);
		t3.left = t6;
		t3.right = t7;

		/*
		 * Depth First Traversals: (a) Inorder (Left, Root, Right) : 4 2 5 1 3 (b)
		 * Preorder (Root, Left, Right) : 1 2 4 5 3 (c) Postorder (Left, Right, Root) :
		 * 4 5 2 3 1
		 */

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

	public static TreeNode constructNodes(int[] pre, int[] in) {
		TreeNode root = null;
		if (pre.length == 0)
			return root;
		// get the root and 1st left node from preorder
		root = new TreeNode(pre[0]);
		if (pre.length == 1)
			return root;
		TreeNode l = new TreeNode(pre[1]);
		root.left = l;
		TreeNode tempLeft = l; 
		// find the index of left node in inorder
		// index could be 0th position - it means left node does not have child nodes
		// index could be greater than 0 - it means left node has child nodes
		int lI = findIndex(in, l);
			
			
		// find the index of root node in inorder
		// construct left sub tree until root node index
		// make left subtree as root left
		// get last node value of left subtree
		// find the index of last node value in preorder. the node next to his index
		// is right node
		// find the index of this right node in inorder
		
		// index could be 0th position - it means left node does not have child nodes
		// index could be greater than 0 - it means left node has child nodes
		// construct right sub tree
		// make right subtree as root right
		return root;
	}
	public static int findIndex(int[] arr, TreeNode n) {
		for(int i=0;i<arr.length;i++) {
			if(arr[i]==n.val)
				return i;
		}
		return 0;
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