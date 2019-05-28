package com.myoffer.first;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//����������������ǵݹ鷽ʽ
public class InorderTraversal {

	public List<Integer> inorderTraversal(TreeNode root) {
		// �ǵݹ���⣬����ջ
		List<Integer> list = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<>();
		if (root == null) {
			return list;
		}
		TreeNode cur = root;
		while (cur != null || !stack.isEmpty()) {
			// ��ջ,ֱ�������������ӽڵ�Ϊ��ʱ
			if (cur != null) {
				stack.push(cur);
				cur = cur.left;
			}
			// ��ջ�����ҽ��ýڵ㸳����ǰ�ڵ㣬���ʸýڵ��ֵ����������������
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
