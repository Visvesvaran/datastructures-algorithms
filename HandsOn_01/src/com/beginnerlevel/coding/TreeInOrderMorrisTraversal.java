package com.beginnerlevel.coding;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import com.beginnerlevel.coding.TreeValidBST.TreeNode;

/*
Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]
*/

public class TreeInOrderMorrisTraversal {

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
		TreeNode root = new TreeNode(2);
		TreeNode l1 = new TreeNode(1);
		root.left = l1;
		TreeNode r1 = new TreeNode(3);
		root.right = r1;
		TreeNode n1 = new TreeNode(15);
		r1.left = n1;
		TreeNode n2 = new TreeNode(7);
		r1.right = n2;
		System.out.println(inorderTraversal(root));

	}
	/*
	 Approach 3: Morris Traversal
In this method, we have to use a new data structure-Threaded Binary Tree, and the strategy is as follows:

Step 1: Initialize current as root

Step 2: While current is not NULL,

If current does not have left child

    a. Add current’s value

    b. Go to the right, i.e., current = current.right

Else

    a. In current's left subtree, make current the right child of the rightmost node

    b. Go to this left child, i.e., current = current.left
For example:


          1
        /   \
       2     3
      / \   /
     4   5 6

First, 1 is the root, so initialize 1 as current, 1 has left child which is 2, the current's left subtree is

         2
        / \
       4   5
So in this subtree, the rightmost node is 5, then make the current(1) as the right child of 5. Set current = cuurent.left (current = 2). The tree now looks like:

         2
        / \
       4   5
            \
             1
              \
               3
              /
             6
For current 2, which has left child 4, we can continue with thesame process as we did above

        4
         \
          2
           \
            5
             \
              1
               \
                3
               /
              6
then add 4 because it has no left child, then add 2, 5, 1, 3 one by one, for node 3 which has left child 6, do the same as above. Finally, the inorder taversal is [4,2,5,1,6,3].
 
	 */
	public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> nodes = new ArrayList<>();
        TreeNode cur = root;
        while (cur != null) {
            if (cur.left != null) {
                TreeNode pre = cur.left;
                while ((pre.right != null) && (pre.right != cur)) {
                    pre = pre.right;
                }
                if (pre.right == null) {
                    pre.right = cur;
                    cur = cur.left;
                } else {
                    pre.right = null;
                    nodes.add(cur.val);
                    cur = cur.right;
                }
            } else {
                nodes.add(cur.val);
                cur = cur.right;
            }
        }
        return nodes;
    }
	public static List<Integer> inorderTraversal_Stack(TreeNode root) {
		List<Integer> list = new ArrayList();
		if (root == null)
			return list;
		Stack<TreeNode> st = new Stack();
		TreeNode temp = root;
		while (temp != null || !st.isEmpty()) {
			while (temp != null) {
				st.push(temp);
				temp = temp.left;
			}
			temp = st.pop();
			list.add(temp.val);
			temp = temp.right;
		}

		return list;
	}

	public static List<Integer> inorderTraversal_Recursion(TreeNode root) {
		List<Integer> list = new ArrayList();
		inorder(root, list);
		return list;
	}

	public static void inorder(TreeNode root, List<Integer> list) {
		if (root == null)
			return;
		inorder(root.left, list);
		if (root != null)
			list.add(root.val);
		inorder(root.right, list);
	}
}
