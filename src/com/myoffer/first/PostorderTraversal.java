package com.myoffer.first;
/**
 * 非递归方法后序遍历输出二叉树
 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class PostorderTraversal {
	public List<Integer> postorderTraversal(TreeNode root) {
		// 非递归求解	
		List<Integer> list = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<>();
		if (root == null)
			return list;
		stack.push(root);// 根节点入栈
		TreeNode pre = null;// 记录上一个访问过的节点
		while (!stack.isEmpty()) {
			TreeNode cur = stack.peek();// 查看当前栈顶的节点
			// 当前节点左右子树均为空或者上次访问的节点为当前节点的子节点，
			// 则访问该节点，出栈
			if ((cur.left == null && cur.right == null) || (pre != null && (pre == cur.left || pre == cur.right))) {
				list.add(cur.value);
				pre = cur;
				stack.pop();
			} else {
				// 先入栈右节点
				if (cur.right != null)
					stack.push(cur.right);
				// 再入栈左节点
				if (cur.left != null)
					stack.push(cur.left);
			}
		}
		return list;
	}

	//第二种解法
	public List<Integer> postorderTraversal1(TreeNode root) {
		//Linkedlist可以用作栈
		LinkedList<Integer> ans = new LinkedList<>();
		Stack<TreeNode> stack = new Stack<>();
		if (root == null)
			return ans;
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode cur = stack.pop();//出栈并赋给cur
			ans.addFirst(cur.value);//相当于栈push
			if (cur.left != null) {
				stack.push(cur.left);
			}
			if (cur.right != null) {
				stack.push(cur.right);
			}
		}
		return ans;
	}
}
