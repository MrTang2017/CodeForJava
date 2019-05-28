package com.myoffer.first;

import java.util.HashMap;
import java.util.Map;
/**
 * 
 * ɾ�����������е��ظ�Ԫ�أ�����ԭ����û�г��ֵ�Ԫ��
 * @author ����
 *
 */
public class DeleteDuplicate2 {

	public ListNode deleteDuplicates(ListNode head) {
        if(head==null)
            return null;
        if(head.next==null){
            return head;
        }
        Map<ListNode,Integer> map=new HashMap<ListNode, Integer>();
        ListNode cur=head;
        while(cur!=null && cur.next!=null){
        	//�����ظ��Ľ��
            if(cur.next.value==cur.value){
                map.put(cur,cur.value);
            }
            cur=cur.next;
        }
        ListNode pNode=head;
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode pre=dummy;
        while(pNode!=null){
        	//�����ﲻ����containsKey�����жϣ���Ϊֵһ���Ľڵ��ַ��һ����
        	//����ͬһ�����󣬻�ȡ���Ľڵ�����Ǳ�����ֵһ���Ľڵ㣬���Դ˽ڵ�Ǳ�
        	//�ڵ�
            if(map.containsValue(pNode.value)){
                pre.next=pNode.next;
                pNode=pre.next;
            } 
            else{
                pre=pNode;
                pNode=pNode.next;
            }
        }
        return dummy.next;
        
    }
	
	
	public ListNode deleteDuplication2(ListNode pHead)
    {
        if(pHead==null || pHead.next==null)
            return pHead;
        //��һ�������ռ�       
        ListNode node=pHead;//�����ڵ�
        ListNode yummy=new ListNode(-1);//����ڵ�
        yummy.next=pHead;
        ListNode preNode=yummy;//ǰ���ڵ�
        while(node!=null && node.next!=null){
        	ListNode pNode=node.next;
            if(node.value==pNode.value){
            	while(pNode!=null && pNode.value==node.value) {   		
            		pNode=pNode.next;       		
            	}
                preNode.next=pNode;
                node=pNode;
            }
            else{
                preNode=node;
                node=pNode;
            }
        }
        return yummy.next;
    }
}
