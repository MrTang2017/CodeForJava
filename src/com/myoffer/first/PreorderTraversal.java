package com.myoffer.first;

/**
 * 前序遍历二叉树的非递归方式
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreorderTraversal {
	public List<Integer> preorderTraversal(TreeNode root) {
		// 非递归求解
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
