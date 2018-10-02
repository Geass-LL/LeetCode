package Leet;

import DS.ListNode;

public class q24 {
    public ListNode swapPairs(ListNode head) {
        ListNode now=head;
        if(head==null || head.next==null) {
        	return head;
        }
        ListNode res=head.next;
        while(now!=null && now.next!=null) {
	        ListNode next=now.next;
	        if(next.next==null) {
	        	next.next=now;
	        	now.next=null;
	        }else {
		        ListNode twonext=next.next;
		        if(twonext.next==null) {
		        	now.next=twonext;
		        	next.next=now;
		        	return res;
		        }else {
			        next.next=now;
			        now.next=twonext.next;
			        now=twonext;
		        }
	        }
        }
        return res;
    }
}
