package com.myoffer.first;
/**
 * �ǵݹ鷽������������������
 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class PostorderTraversal {
	public List<Integer> postorderTraversal(TreeNode root) {
		// �ǵݹ����	
		List<Integer> list = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<>();
		if (root == null)
			return list;
		stack.push(root);// ���ڵ���ջ
		TreeNode pre = null;// ��¼��һ�����ʹ��Ľڵ�
		while (!stack.isEmpty()) {
			TreeNode cur = stack.peek();// �鿴��ǰջ���Ľڵ�
			// ��ǰ�ڵ�����������Ϊ�ջ����ϴη��ʵĽڵ�Ϊ��ǰ�ڵ���ӽڵ㣬
			// ����ʸýڵ㣬��ջ
			if ((cur.left == null && cur.right == null) || (pre != null && (pre == cur.left || pre == cur.right))) {
				list.add(cur.value);
				pre = cur;
				stack.pop();
			} else {
				// ����ջ�ҽڵ�
				if (cur.right != null)
					stack.push(cur.right);
				// ����ջ��ڵ�
				if (cur.left != null)
					stack.push(cur.left);
			}
		}
		return list;
	}

	//�ڶ��ֽⷨ
	public List<Integer> postorderTraversal1(TreeNode root) {
		//Linkedlist��������ջ
		LinkedList<Integer> ans = new LinkedList<>();
		Stack<TreeNode> stack = new Stack<>();
		if (root == null)
			return ans;
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode cur = stack.pop();//��ջ������cur
			ans.addFirst(cur.value);//�൱��ջpush
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
