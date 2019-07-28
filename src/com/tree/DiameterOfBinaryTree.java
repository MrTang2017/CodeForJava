package com.tree;

/**
 * 给定一棵二叉树，你需要计算它的直径长度。
 * 一棵二叉树的直径长度是任意两个结点路径长度中的最大值。
 * 这条路径可能穿过根结点。
 * @author 汤吉
 *
 */

public class DiameterOfBinaryTree {
	int max=0;
	
     public int diameterOfBinaryTree(TreeNode root) {
    	 maxDepth(root);
    	/*if (root==null) {
			return 0;
		}
        int maxLeftLen=maxDepth(root.left);
        int maxRightLen=maxDepth(root.right);
        max=Math.max(max,maxLeftLen+maxRightLen);
        if (root.left!=null) {
			diameterOfBinaryTree(root.left);
		}
        if (root.right!=null) {
			diameterOfBinaryTree(root.right);
		}
		*/
        return max;
    }

	private int maxDepth(TreeNode root) {
		if (root==null) {
			return 0;
		}
         int leftH=maxDepth(root.left);
         int rightH=maxDepth(root.right);
        //记录最大值
         max=Math.max(max, leftH+rightH);
         return Math.max(leftH, rightH)+1;
	}

}
