package com.tree;

/**
 * ����һ�ö�����������Ҫ��������ֱ�����ȡ�
 * һ�ö�������ֱ�������������������·�������е����ֵ��
 * ����·�����ܴ�������㡣
 * @author ����
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
        //��¼���ֵ
         max=Math.max(max, leftH+rightH);
         return Math.max(leftH, rightH)+1;
	}

}
