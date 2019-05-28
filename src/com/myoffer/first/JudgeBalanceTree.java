package com.myoffer.first;

public class JudgeBalanceTree {
/**
 * �������ϱ����ڵ㣬�����������߶Ȳ����������ֹͣ��
 * @param root
 * @return
 */
	
	public boolean IsBalanced_Solution(TreeNode root) {
        int result=depth(root);
        return result!=-1;    
    }
	
	private int depth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int left = depth(root.left);
		int right = depth(root.right);
		if (Math.abs(left - right) > 1)
			return -1;
		return left > right ? left + 1 : right + 1;
	}
	public static void main(String[] args) {
		
		
		
		
		
		
		
		
		
		

	}

}
