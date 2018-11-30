package Leet;

import DS.ListNode;

public class q142 {
	public ListNode detectCycle(ListNode head) {
		ListNode sp=head,fp=head;
		if(fp==null||fp.next==null) return null;
		while(fp!=null&&fp.next!=null) {
			fp=fp.next.next;
			sp=sp.next;
			if(fp==sp) break;
		}
		if(fp==null||fp.next==null) return null;
		sp=head;
		while(sp!=fp) {
			fp=fp.next;
			sp=sp.next;
		}
		return sp;
    }
}
