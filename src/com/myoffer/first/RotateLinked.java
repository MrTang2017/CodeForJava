package com.myoffer.first;
/**
 * ��ת�б�
 * ����1->2->3->4->5,k=2
 * �����4->5->1->2->3
 * @author ����
 *
 */
public class RotateLinked {

	 public ListNode rotateRight(ListNode head, int k) {
	        if(head==null){
	            return null;
	        }
	        if(head.next==null){
	            return head;
	        }
	        
	        int n=1;
	        ListNode oldNode=head;
	        while(oldNode.next!=null){
	            oldNode=oldNode.next;
	            ++n;
	        }  
	        oldNode.next=head;//�ջ�
	        
	        int newTail=n-k%n-1;//�����µ�β����λ��
	        ListNode newTailNode=head;
	        for(int i=0;i<newTail;i++){
	            newTailNode=newTailNode.next;
	        }
	        ListNode newHeadNode=newTailNode.next;//�µ�ͷ���
	        newTailNode.next=null;
	        return newHeadNode;   
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
