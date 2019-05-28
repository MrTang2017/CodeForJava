package com.myoffer.first;
/**
 * 旋转列表
 * 例如1->2->3->4->5,k=2
 * 输出：4->5->1->2->3
 * @author 汤吉
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
	        oldNode.next=head;//闭环
	        
	        int newTail=n-k%n-1;//计算新的尾结点的位置
	        ListNode newTailNode=head;
	        for(int i=0;i<newTail;i++){
	            newTailNode=newTailNode.next;
	        }
	        ListNode newHeadNode=newTailNode.next;//新的头结点
	        newTailNode.next=null;
	        return newHeadNode;   
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
