package com.tree;


/**
 * ·´×ª¶þ²æÊ÷
 * @author ÌÀ¼ª
 *
 */
public class InvertTree {
	
	
	

    public TreeNode invertTree(TreeNode root) {
        if (root==null) {
			return null;
		}
       TreeNode rightNode=root.right;    
		root.right=root.left;
    	root.left=rightNode;
    	invertTree(root.left);
    	invertTree(root.right);
    	return root;
    }

}
