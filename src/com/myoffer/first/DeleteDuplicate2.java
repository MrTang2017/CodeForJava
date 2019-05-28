package com.myoffer.first;

import java.util.HashMap;
import java.util.Map;
/**
 * 
 * 删除有序链表中的重复元素，保留原链表没有出现的元素
 * @author 汤吉
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
        	//保留重复的结点
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
        	//在这里不能用containsKey进行判断，因为值一样的节点地址不一样，
        	//不是同一个对象，获取到的节点可能是被后面值一样的节点，所以此节点非彼
        	//节点
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
        //用一个辅助空间       
        ListNode node=pHead;//遍历节点
        ListNode yummy=new ListNode(-1);//哑铃节点
        yummy.next=pHead;
        ListNode preNode=yummy;//前驱节点
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
