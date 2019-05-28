package com.myoffer.first;

/**
 * ����һ���������ص�һ���뻷�Ľ�� 
 * @author ����
 *
 */
public class FindFirstEntrNode {
	public ListNode detectCycle(ListNode head) {
		if (head == null || head.next == null) {
			return null;
		}
		boolean isCycle = false;//�ж��Ƿ��л�
		ListNode slow = head;//��ָ�룬ÿ����һ��
		ListNode fast = head;//��ָ�룬ÿ��������
		while (slow != null && fast != null) {
			slow = slow.next;
			if (fast.next == null) {
				// �޻�
				return null;
			}
			fast = fast.next.next;
			//��������ʾ�л�
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
