package com.tree;

/**
 * �������������kС
 * @author ����
 *
 */
public class KthSmallest {
	
	
	int value=0,count=0;
	 public int kthSmallest(TreeNode root, int k) {
	        
	    //�������
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
