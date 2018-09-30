package Leet;

import java.util.List;
import DS.ListNode;
/*
 * 先翻转链表，然后删除，再翻转回来。
 * 翻转链表：NNNPPNNN即：3PP3
 * while(now!=null)
 * next=now.next
 * now.next=prev
 * prev=now
 * now=next
 * 最后return prev
 */
public class q19 {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode rev=reverse(head);
		ListNode cur=rev;
		if (n==1) {
			rev=rev.next;
		}else {
			int i=2;
			while(cur!=null) {
				if(i==n) {
					cur.next=cur.next.next;
					break;
				}
				cur=cur.next;
				i++;
			}
		}
		return reverse(rev);
    }
	ListNode reverse(ListNode head) {
		ListNode now=head;
		ListNode prev=null;
		while(now!=null) {
			ListNode next=now.next;
			now.next=prev;
			prev=now;
			now=next;
		}
		return prev;
	}
}
