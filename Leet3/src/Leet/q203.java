package Leet;

import DS.ListNode;

public class q203 {
	public ListNode removeElements(ListNode head, int val) {
        if(head==null) return null;
        while(head.val==val) {
            if(head.next==null) return null;
        	else head=head.next;
        }
        ListNode truehead=head;
        while(head.next!=null) {
        	if(head.next.val==val) {
        		if(head.next.next==null) {
        			head.next=null;
        			break;
        		}else {
        			head.next=head.next.next;
        		}
        	}else {
        		head=head.next;
        	}
        }
        return truehead;
    }
}
