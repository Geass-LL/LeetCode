package Leet;

import DS.ListNode;

public class q328 {
	public ListNode oddEvenList(ListNode head) {
        if(head==null||head.next==null)	return head;
        int i=2;
        ListNode oddhead=head,evenhead=head.next;
        ListNode reshead=oddhead,nexthead=evenhead;
        head=head.next.next;
        while(head!=null) {
        	i++;
        	if(i%2==1) {
        		oddhead.next=head;
        		oddhead=oddhead.next;
        	}else {
        		evenhead.next=head;
        		evenhead=evenhead.next;
        	}
        }
        evenhead.next=null;
        oddhead.next=evenhead;
        return reshead;
    }
}
