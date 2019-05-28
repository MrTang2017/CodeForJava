package com.myoffer.first;

/**
 * 给定一个链表，返回第一个入环的结点 
 * @author 汤吉
 *
 */
public class FindFirstEntrNode {
	public ListNode detectCycle(ListNode head) {
		if (head == null || head.next == null) {
			return null;
		}
		boolean isCycle = false;//判断是否有环
		ListNode slow = head;//慢指针，每次走一步
		ListNode fast = head;//快指针，每次走两步
		while (slow != null && fast != null) {
			slow = slow.next;
			if (fast.next == null) {
				// 无环
				return null;
			}
			fast = fast.next.next;
			//相遇，表示有环
			if (slow == fast) {
				isCycle = true;
				break;
			}
		}
		if (isCycle) {
			ListNode q = head;
			while (q != slow) {
				q = q.next;
				slow = slow.next;
			}
			return q;
		}
		return null;
	}

	public static void main(String[] args) {

	}

}
