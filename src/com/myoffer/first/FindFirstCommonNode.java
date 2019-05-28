package com.myoffer.first;

import java.util.Stack;

public class FindFirstCommonNode {
	/**
	 * 找出两个链表的第一个公共结点
	 * 
	 * @param head1
	 * @param head2
	 * @return
	 */

	/*
	 * public static ListNode findFirstCommonNode(ListNode head1,ListNode head2) {
	 * //先用递归 if (head1==null || head2==null) { return null; }
	 * if(head1.value<head1.value) { findFirstCommonNode(head1.next, head2); }else
	 * if (head1.value>head2.value) { findFirstCommonNode(head1, head2.next);
	 * 
	 * }else { return head1; } return null; }
	 */

	public static ListNode findFirstCommonNode(ListNode head1, ListNode head2) {
		// 求出两个链表的长度
		int length1 = getLength(head1);
		int length2 = getLength(head2);
		int difLength = length1 - length2;
		ListNode pNode1 = head1;
		ListNode pNode2 = head2;
		if (length2 > length1) {
			pNode1 = head2;
			pNode2 = head1;
			difLength = length2 - length1;
		}
		for (int i = 0; i < difLength; i++) {
			pNode1 = pNode1.next;
		}

		while (pNode1 != null && pNode2 != null && pNode1 != pNode2) {
			pNode1 = pNode1.next;
			pNode2 = pNode2.next;
		}

		ListNode pFirstCommonNode = pNode1;
		return pFirstCommonNode;
	}

	private static int getLength(ListNode head1) {
		// TODO Auto-generated method stub

		ListNode curNode = head1;
		int count = 0;
		while (curNode != null) {
			++count;
			curNode = curNode.next;
		}
		return count;
	}

	 public  static ListNode findFirstCommonNode1(ListNode pHead1, ListNode pHead2) {
	        if(pHead1==null || pHead2==null)
	            return null;
	        Stack<ListNode> stack1=new Stack<>();
	        Stack<ListNode> stack2=new Stack<>();
	        while(pHead1!=null){
	            stack1.push(pHead1);
	            pHead1=pHead1.next;
	        }
	        while(pHead2!=null){
	            stack2.push(pHead2);
	            pHead2=pHead2.next;
	        }
	        while(!stack1.isEmpty() && !stack2.isEmpty()){
	           if(stack1.peek()==stack2.peek()){
	               stack1.pop();
	               stack2.pop();
	           }
	            else{
	                break;
	            }
	        }
	        ListNode commonNode=null;
	        if(!stack1.isEmpty())
	            commonNode=stack1.peek().next;
	        if(!stack2.isEmpty())
	            commonNode=stack2.peek().next;
	        return commonNode;
	    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
