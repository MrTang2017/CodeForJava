package com.tree;

public class SumOfLeftTree {

	int result = 0;

	public int sumOfLeftLeaves(TreeNode root) {
		if (root == null) {
			return 0;
		}
		if (root.left != null && (root.left.left == null && root.left.right == null)) {
			result += root.left.val;
		}
		sumOfLeftLeaves(root.left);//×ó×ÓÊ÷
		sumOfLeftLeaves(root.right);//ÓÒ×ÓÊ÷
		return result;
	}

}
