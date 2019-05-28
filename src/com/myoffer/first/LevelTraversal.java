package com.myoffer.first;

/**
 * �������Ĳ�α���
 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelTraversal {
	class ListNode {
		ListNode next=null;
		int value;

		public ListNode(int value) {
			this.value = value;
		}
	}

	public List<List<Integer>> levelOrder(TreeNode root) {
		LinkedList<TreeNode> queue = new LinkedList<>();
		if (root == null) {
			return null;
		}
		List<Integer> list = new ArrayList<Integer>();
		List<List<Integer>> list1 = new ArrayList<List<Integer>>();
		queue.addLast(root);
		TreeNode cur = root;
		while (!queue.isEmpty()) {
			cur = queue.removeLast();
			list.add(cur.value);
			if (queue.isEmpty()) {
				list1.add(list);
				list = new ArrayList<Integer>();
			}
			if (cur.left != null)
				queue.addLast(cur.left);
			if (cur.right != null)
				queue.addLast(cur.right);
		}
		return list1;
	}

	public List<List<Integer>> levelOrder2(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		if (root == null) {
			return new ArrayList<>();
		}
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		queue.add(root);
		while (!queue.isEmpty()) {
			// ��¼���еĴ�С��Ҳ���Ǹò�Ľڵ����
			int count = queue.size();
			List<Integer> list1 = new ArrayList<Integer>();
			while (count > 0) {
				// ���ʶ����е�Ԫ�أ�Ҳ���Ǹò�Ľڵ�
				TreeNode node = queue.poll();
				list1.add(node.value);
				// ����һ�������
				if (node.left != null)
					queue.add(node.left);
				if (node.right != null)
					queue.add(node.right);
				count--;
			}
			list.add(list1);
		}
		return list;
	}
}
