package com.myoffer.first;

public class FindKthTotail {

	/**
	 * 找到链表倒数第k个结点
	 * @param head
	 * @param k
	 * @return
	 */
	public static ListNode findKthToTail(ListNode head, int k) {
		if(head==null || k==0){
            return null;
        }
        ListNode pHead=head;
        ListNode pBehind=null;
        for(int i=0;i<k;i++){
            if(pHead.next!=null)
            pHead=pHead.next;
            else{
                return null;
            }
        }
        pBehind=head;
        while(pHead.next!=null){
            pHead=pHead.next;
            pBehind=pBehind.next;
        }
        ListNode currentNode=pBehind.next;
        return currentNode;
	}
	
	public static void main(String[] args) {
	}

}
