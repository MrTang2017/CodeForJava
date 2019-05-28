package com.myoffer.first;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//中序遍历二叉树，非递归方式
public class InorderTraversal {

	public List<Integer> inorderTraversal(TreeNode root) {
		// 非递归求解，利用栈
		List<Integer> list = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<>();
		if (root == null) {
			return list;
		}
		TreeNode cur = root;
		while (cur != null || !stack.isEmpty()) {
			// 入栈,直至遍历到最左子节点为空时
			if (cur != null) {
				stack.push(cur);
				cur = cur.left;
			}
			// 出栈，并且将该节点赋给当前节点，访问该节点的值，继续遍历右子树
			else {
				cur = stack.pop();
				list.add(cur.value);
				cur = cur.right;
			}
		}
		return list;
	}

	public static void main(String[] args) {

	}

}
