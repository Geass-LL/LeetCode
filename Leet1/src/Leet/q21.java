package Leet;

import DS.ListNode;
/*
 * 简单的拼接，没什么好说的。
 */
public class q21 {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode res=new ListNode(0);
		ListNode head=res;
        while(l1!=null && l2!=null) {
        	if(l1.val<l2.val) {
        		res.next=l1;
        		l1=l1.next;
        	}else {
        		res.next=l2;
        		l2=l2.next;
        	}
        	res=res.next;
        }
        if(l1!=null) {
        	res.next=l1;
        }else {
        	res.next=l2;
        }
        return head.next;
    }
}
