package com.tree;

public class Subtree {

	
	/**
	 * ���� s ���Ƿ������ t ������ͬ�ṹ�ͽڵ�ֵ������
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
