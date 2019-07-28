package com.tree;

/**
 * 最小深度
 * @author 汤吉
 *
 */
public class MinDepth {
	
	
	  public int minDepth(TreeNode root) {
		     if (root==null) {
			     return 0;
		   }
		     int leftDepth=minDepth(root.left);
		     int rightDepth=minDepth(root.right);
		     if (leftDepth==0 || rightDepth==0) {
				return 1+leftDepth+rightDepth;
			}
		    return Math.min(leftDepth, rightDepth)+1;
		   
	  }
	
	

	



	public static void main(String[] args) {
		

	}

}
