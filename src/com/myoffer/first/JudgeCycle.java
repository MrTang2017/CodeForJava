package com.myoffer.first;

public class JudgeCycle {

	public static boolean judgeCycle(ListNode head) {
		// ��ָ����ֻ��һ����㶼����ɻ�
		if (head == null || head.next == null) {
			return false;
		}
		ListNode slow = head;
		ListNode fast = head.next;
		while (slow != fast) {
			if (fast == null || fast.next == null) {
				return false;
			}
			fast = fast.next.next;
			slow = slow.next;
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
