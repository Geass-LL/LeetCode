package Leet;

import DS.ListNode;

/*
 * 把第一个链表做成环；
 * 如果有交点那么第二个链表就存在一个第一个链表形成的环，则环的入口为所求；
 * 当然无论有没有交点，在返回时都需要还原环为初始的链表。
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
