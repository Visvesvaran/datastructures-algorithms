package com.beginnerlevel.coding;

public class TreeDepth {

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
		TreeNode t4 = null;
		TreeNode t5 = null;
		t2.left = t4;
		t2.right = t5;
		TreeNode t6 = new TreeNode(6);
		TreeNode t7 = new TreeNode(7);
		t3.left = t6;
		t3.right = t7;

		maxDepth(t1);
	}
	
	public static int maxDepth (TreeNode node) {
		 if (node == null) 
	            return 0; 
	        else 
	        { 
	            /* compute the depth of each subtree */
	            int lDepth = maxDepth(node.left); 
	            int rDepth = maxDepth(node.right); 
	   
	            /* use the larger one */
	            if (lDepth > rDepth) 
	                return (lDepth + 1); 
	             else 
	                return (rDepth + 1); 
	        }
	}
}
