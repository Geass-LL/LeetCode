package Leet;

import java.util.List;
import DS.ListNode;
/*
 * �ȷ�ת����Ȼ��ɾ�����ٷ�ת������
 * ��ת����NNNPPNNN����3PP3
 * while(now!=null)
 * next=now.next
 * now.next=prev
 * prev=now
 * now=next
 * ���return prev
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
