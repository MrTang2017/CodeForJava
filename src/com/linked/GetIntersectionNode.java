package com.linked;

import java.util.Stack;

public class GetIntersectionNode {
	
	
	class ListNode{
		int val;
		ListNode next;
		
		public ListNode(int val) {
			this.val=val;
			next=null;
		}
		
	}
	
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (headA == null || headB == null) {
			return null;
		}

		Stack<ListNode> stack1 = new Stack<>();
		Stack<ListNode> stack2 = new Stack<>();
		ListNode node1 = headA;
		ListNode node2 = headB;
		while (node1 != null) {
			stack1.push(node1);
			node1 = node1.next;
		}
		while (node2 != null) {
			stack2.push(node2);
			node2 = node2.next;
		}

		while (!stack1.isEmpty() && !stack2.isEmpty()) {
			if (stack1.peek() == stack2.peek()) {
				ListNode curNode=stack1.pop();
				stack2.pop();
				if (stack1.isEmpty() || stack2.isEmpty()) {
					return curNode;
				}
			} else {
				return stack1.peek().next;
			}
			
			
		}

		return null;

	}

	public static void main(String[] args) {
		
	}

}
