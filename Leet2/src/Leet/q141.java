package Leet;

import DS.ListNode;



public class q141 {
	public boolean hasCycle(ListNode head) {
		if(head==null) return false;
        ListNode slow=head,fast=head;
        while(fast.next!=null&&slow.next!=null) {
        	fast=fast.next.next;
        	slow=slow.next;
        	if(fast.equals(slow)) return true;
        }
        return false;
    }
}
