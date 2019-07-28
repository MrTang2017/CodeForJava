package com.tree;

public class LowestCommonAncestor {

	/**
	 * 二叉查找树的最近公共祖先
	 * 
	 * @param root
	 * @param p
	 * @param q
	 * @return
	 */
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
      /* min=p.val;
       max=q.val;
       if (p.val>q.val) {
		min=q.val;
		max=p.val;
	   }
       
       return lowestCommonAncestor(root);
	}
	private TreeNode lowestCommonAncestor(TreeNode root) {
		if (root==null) {
			return null;
		}
		if (root.val>=min && root.val<=max) {
			return root;
		}
		TreeNode left=lowestCommonAncestor(root.left);
		TreeNode right=lowestCommonAncestor(root.right);
		return left!=null?left:right;	*/	
	 if (root.val>q.val && root.val>q.val) {
		return lowestCommonAncestor(root.left, p, q);
	}
	 if (root.val<q.val && root.val <q.val) {
		 return lowestCommonAncestor(root.right, p, q);
		
	}
		return root;
	}

}
