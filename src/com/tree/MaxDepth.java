package com.tree;

public class MaxDepth {
	
	
	
	
	public int maxDepth(TreeNode root) {
		
		if (root==null) {
			return 0;
		}
		return (int)Math.max(1+maxDepth(root.left),1+maxDepth(root.right) );
		
		
	}

	public static void main(String[] args) {

		
		
		
		
		

	}

}
