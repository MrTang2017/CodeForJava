package com.tree;

public class Subtree {

	
	/**
	 * 检验 s 中是否包含和 t 具有相同结构和节点值的子树
	 * @param s
	 * @param t
	 * @return
	 */
	
     public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s==null) {
			return false;
		}
        if (t==null) {
			return true;
		}
        return isSame(s, t)
        		|| isSubtree(s.left, t)|| isSubtree(s.right, t);
                  
    }

	private boolean isSame(TreeNode s, TreeNode t) {
		if (s==null && t==null) {
			return true;
		}
		if((s==null || t==null))
            return false;
		if (s.val==t.val) {
			return isSame(s.left, t.left) && isSame(s.right, t.right);
		}	
		return false;
	}
}
