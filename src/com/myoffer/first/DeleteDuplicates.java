package com.myoffer.first;
/**
 * ɾ��������ظ���Ԫ��
 * @author ����
 *
 */
public class DeleteDuplicates {

	public static ListNode deleteDuplicates(ListNode head) {
		   ListNode preNode=null;
	        ListNode pHead=head;
	        while(pHead!=null && pHead.next!=null){
	            preNode=pHead;
	            if(pHead.next.value==preNode.value){
	                preNode.next=pHead.next.next;
	                deleteDuplicates(preNode);
	            }  
	            pHead=pHead.next;
	        }
	        return head;
	}
	
	public static void main(String[] args) {
		
		
		

	}

}
