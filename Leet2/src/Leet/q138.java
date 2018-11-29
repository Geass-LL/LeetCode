package Leet;

import DS.RandomListNode;

/*不采用Map的方法，感觉博主老哥好厉害啊。具体见Onenote。
 * 参考博客：https://www.cnblogs.com/jdneo/p/4748972.html 
 */

public class q138 {
	public RandomListNode copyRandomList(RandomListNode head) {
		if(head==null) return null;
		RandomListNode res,l1,l2;
		for(l1=head;l1!=null;l1=l1.next.next) {
			l2=new RandomListNode(l1.label);
			l2.next=l1.next;
			l1.next=l2;
		}
		res=head.next;
		for(l1=head;l1!=null;l1=l1.next.next) {
			if(l1.random!=null) {
				l1.next.random=l1.random.next;
			}
		}
		for(l1=head;l1!=null;l1=l1.next) {
			l2=l1.next;
			l1.next=l2.next;
			if(l2.next!=null) {
				l2.next=l2.next.next;
			}
		}
		return res;
    }
}
