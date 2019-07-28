package com.tree;

public class HasPathSum {

	public boolean hasPathSum(TreeNode root, int sum) {
		return preOrder(root, sum);
	}

	private boolean preOrder(TreeNode root, int sum) {
		if (root == null) {
			return false;
		}
		if (root.left == null && root.right == null && sum == root.val) {
			return true;
		}
		return preOrder(root.left, sum - root.val) || preOrder(root.right, sum - root.val);
	}
}
