package Leet;

import DS.ListNode;
/*
 * Easy
 */
public class q83 {
	public ListNode deleteDuplicates(ListNode head) {
        if(head==null) {
        	return null;
        }
        ListNode res=head;
        ListNode trueres=res;
        while(head.next!=null) {
        	if(head.next.val!=head.val) {
        		res.next=head.next;
        		res=res.next;
        	}
        	head=head.next;
        }
        res.next=null;
        return trueres;
    }
}
