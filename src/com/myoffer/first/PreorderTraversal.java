package com.myoffer.first;

/**
 * ǰ������������ķǵݹ鷽ʽ
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreorderTraversal {
	public List<Integer> preorderTraversal(TreeNode root) {
		// �ǵݹ����
		List<Integer> list = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<>();
		if (root == null)
			return list;
		TreeNode cur = root;
		while (cur != null || !stack.isEmpty()) {
			if (cur != null) {
				list.add(cur.value);
				stack.push(cur);
				cur = cur.left;
			} else {
				cur = stack.pop();
				cur = cur.right;
			}
		}
		return list;
	}
}
