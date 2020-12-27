package com.beginnerlevel.coding;

import java.util.HashMap;
import java.util.HashSet;

/* 
Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

 

Example 1:

Input: root = [3,1,4,null,2], k = 1
   3
  / \
 1   4
  \
   2
Output: 1
Example 2:

Input: root = [5,3,6,2,4,null,null,1], k = 3
       5
      / \
     3   6
    / \
   2   4
  /
 1
Output: 3
Follow up:
What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?

 

Constraints:

The number of elements of the BST is between 1 to 10^4.
You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
 */

public class TreeKthSmallest {

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
		TreeNode t2 = new TreeNode(1);
		TreeNode t3 = new TreeNode(4);
		t1.left = t2;
		t1.right = t3;
//		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(2);
//		t2.left = t4;
		t2.right = t5;
		System.out.println(kthSmallest(t1, 1));
		TreeNode t6 = new TreeNode(6);
		TreeNode t7 = new TreeNode(7);
		t3.left = t6;
		t3.right = t7;
		
	}
	
	public static int kthSmallest(TreeNode root, int k) {
        int[] val = new int[1];
        inOrder(root, k, 0, val);
        return val[0];
    }
    
    private static void inOrder(TreeNode root, int k, int c, int[] val){
        if(root==null || c==k)
            return;
        inOrder(root.left, k, c, val);
        c++;
        if(c==k)
            val[0] = root.val;
        inOrder(root.right, k, c, val);
    }

	public static int kthSmallest_1(TreeNode root, int k) {
        HashSet<Integer> set = new HashSet<Integer>();
        inOrder_1(root, set);
        Object[] nums = set.toArray();
        return (int) nums[k-1];
    }
    
    private static void inOrder_1(TreeNode root, HashSet<Integer> set){
        if(root==null)
            return;
        inOrder_1(root.left, set);
        set.add(root.val);
        inOrder_1(root.right, set);
    }


}
