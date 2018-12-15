package Leet;

import DS.ListNode;

/*
 * �ѵ�һ���������ɻ���
 * ����н�����ô�ڶ�������ʹ���һ����һ�������γɵĻ����򻷵����Ϊ����
 * ��Ȼ������û�н��㣬�ڷ���ʱ����Ҫ��ԭ��Ϊ��ʼ������
 */

public class q160 {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		
		if(headA==null||headB==null) return null;
		
		ListNode temp=headA;
		while(temp.next!=null) {
			temp=temp.next;
		}
		temp.next=headA;
		
		ListNode slow=headB,fast=headB;
		while(fast!=null&&fast.next!=null) {
			fast=fast.next.next;
			slow=slow.next;
			if(slow==fast) break;
		}
		if(fast==null||fast.next==null) {
			temp.next=null;
			return null;
		}
		slow=headB;
		while(slow!=fast) {
			slow=slow.next;
			fast=fast.next;
		}
		temp.next=null;
		return slow;
    }
}
