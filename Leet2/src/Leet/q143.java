package Leet;

import DS.ListNode;

/*
 * 用快慢指针找到中点，把中点后面的sec2部分反转，然后前后两部分依次连接。
 */

public class q143 {
	public void reorderList(ListNode head) {
		if(head==null||head.next==null) return;
		ListNode sp=head,fp=head.next;
		while(fp!=null&&fp.next!=null) {
			fp=fp.next.next;
			sp=sp.next;
		}
		ListNode sec2=null,now=sp.next,next;//从now开始为后半部分，先记录下来为sp.next，然后把sp.next置null，严格区分前后。
		sp.next=null;
		while(now!=null) {//反转
			next=now.next;
			now.next=sec2;
			sec2=now;
			now=next;
		}
		while(head!=null&&sec2!=null) {//逐次连接，注意这种都是先考虑后面的一环扣一环。
			next=sec2.next;
			sec2.next=head.next;
			head.next=sec2;
			head=sec2.next;
			sec2=next;
		}
    }
}
