package com.linked;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class IsPalindrome {

	class ListNode {
		int val;
		ListNode next;

		public ListNode(int val) {
			this.val = val;
			next = null;
		}

	}

	public boolean isPalindrome(ListNode head) {
		if (head == null) {
			return true;
		}
		Stack<Integer> stack = new Stack<>();
		Queue<Integer> queue = new LinkedList<>();
		while (head != null) {
			stack.push(head.val);
			queue.offer(head.val);
			head = head.next;
		}
		while (!stack.isEmpty()) {
			if (stack.pop().intValue() != queue.poll().intValue()) {
				return false;
			}
		}
		return true;

	}
	
	public boolean isPalindrome2(ListNode head) {
		if (head == null) {
			return true;
		}
		Stack<Integer> stack = new Stack<>();
		ListNode slow=head;
		ListNode quick=head;
		while (quick!=null) {
			if (quick.next==null) {
				break;
			}
			stack.push(slow.val);
			slow=slow.next;	
			quick=quick.next.next;
		}
		//如果链表的个数为奇数，此时slow节点到达中间节点
		if (quick!=null) {
			slow=slow.next;
		}
		while(slow!=null && !stack.isEmpty()) {
			if (slow.val!=stack.pop()) {
				return false;
			}
			slow=slow.next;
		
		}
		return true;

	}
	public static void main(String[] args) {
		Integer i=-168;
		Integer j=-168;
		int a=i;
		int b=j;
		System.out.println(a==b);
		

	}

}
