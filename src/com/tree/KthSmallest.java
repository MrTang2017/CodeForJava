package com.tree;

/**
 * 二叉搜索树求第k小
 * @author 汤吉
 *
 */
public class KthSmallest {
	
	
	int value=0,count=0;
	 public int kthSmallest(TreeNode root, int k) {
	        
	    //中序遍历
	   kthSmallest2(root, k);
	   return value; 
	 }
	private void kthSmallest2(TreeNode root, int k) {
		
		if (root==null) {
			return;
		}
		kthSmallest2(root.left, k);
		if (++count==k) {
			value=root.val;
			return;
		}		
		kthSmallest2(root.right, k);
	
	}
	
	

}
