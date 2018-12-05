package Leet;

import DS.ListNode;

/*
 * 就是把他给出的动画实现了一下，注意，如果返回的链表一开始就是从小到大链接的话，是不用反转的，这样比较好。
 */

public class q147 {
	public ListNode insertionSortList(ListNode head) {
		if(head==null) return null;
		ListNode res=new ListNode(head.val);
		head=head.next;
		while(head!=null) {
			if(head.val<=res.val) {
				ListNode temp=head.next;
				head.next=res;
				res=head;
				head=temp;
			}else {
				ListNode tempres=res;
				while(tempres.next!=null&&tempres.next.val<head.val) {
					tempres=tempres.next;
				}
				ListNode temp=head.next;
				head.next=tempres.next;
				tempres.next=head;
				head=temp;
			}
		}
		return res;
    }
}