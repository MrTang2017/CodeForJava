package com.tree;
/**
 * 判断一棵树是否为平衡二叉树
 * @author 汤吉
 *
 */
public class IsBalance {

	public boolean isBalanced(TreeNode root) {

		if (root == null) {
			return true;
		}
		int leftHigh = 0, rightHigh = 0;
		if (root.left != null) {
			leftHigh = maxDepth(root.left);
		}
		if (root.right != null) {
			rightHigh = maxDepth(root.right);
		}
		int abs = Math.abs(rightHigh - leftHigh);
		if (abs <= 1) {
			return isBalanced(root.left) && isBalanced(root.right);
		}
		return false;

	}

	private int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return (int) Math.max(1 + maxDepth(root.left), 1 + maxDepth(root.right));
	}
}
