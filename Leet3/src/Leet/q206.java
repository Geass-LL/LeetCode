package Leet;

import DS.ListNode;

public class q206 {
	public ListNode reverseList(ListNode head) {
		ListNode prev=null,next;
		while(head.next!=null) {
			next=head.next;
			head.next=prev;
			prev=head;
			head=next;
		}
		head.next=prev;
		return head;
    }
}
