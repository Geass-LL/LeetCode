package Leet;

import DS.ListNode;
/*
 * 先看链表总共有多长，在从应该截取的地方截出来，把前面的接上。
 */
public class q61 {
	public ListNode rotateRight(ListNode head, int k) {
		if(head==null) {
			return null;
		}
		int length=1;
		ListNode temp=head;
        while(temp.next!=null) {
        	length++;
        	temp=temp.next;
        }
        if(k%length==0)//倍数时
        	return head;
        else {
        	int rostep=length-k%length;
        	int cur=0;
        	temp=head;
        	while(cur<rostep-1) {//注意是减1，下一个元素为新的头部
        		temp=temp.next;
        		cur++;
        	}
        	ListNode reshead=temp.next;//新的头部
        	temp.next=null;//新的尾部
        	temp=reshead;
        	while(temp.next!=null) {
        		temp=temp.next;
        	}
        	temp.next=head;//在原来的尾巴接上原来的头
        	return reshead;//返回新的头部
        }
    }
}
