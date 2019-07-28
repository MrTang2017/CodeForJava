package com.tree;

public class PathSum {
	
	
	public class TreeNode {
		  int val;
		  TreeNode left;
		  TreeNode right;
		 TreeNode(int x) { val = x; }
		 }

	 public int pathSum(TreeNode root, int sum) {
	     
		 if (root==null) {
			 return 0;
			
		}
		 
		int res=0;
		//Ç°Ðò±éÀú
		res+=preOrder(root,sum);
		res=res+pathSum(root.left, sum);
		res=res+pathSum(root.right, sum);
	    return res;
		 
	}

	private int preOrder(TreeNode root, int sum) {

        if (root==null) {
			return 0;
		} 
        int res=0; 
        if (root.val==sum) {
             res+=1;
        }
           
        res+=preOrder(root.left, sum-root.val);
        res+=preOrder(root.right, sum-root.val);
        return res;		
	}

}
