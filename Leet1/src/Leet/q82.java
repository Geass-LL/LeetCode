package Leet;

import DS.ListNode;
/*
 * 新建了一个链表，如果有
 * 1、三个不重复的数字：链表的值加一个；
 * 2、结尾两个不重复的数字：链表的值加一个，并结束链表；
 * 非上述两种情况，原始链表向后遍历，同时暂时结束新建的链表。
 * 这样会出现总把原始链表的第一个值无论它是否有重复的情况都作为链表头，
 * 于是进行判断，当重复的时候选择链表头的next返回。
 */
public class q82 {
	public ListNode deleteDuplicates(ListNode head) {
		if(head==null)
			return null;
		ListNode res=head;
		ListNode trueres=res;
		boolean flag=false;
		if(head.next!=null&&head.next.val==head.val) {
			flag=true;//当重复的时候选择链表头的next返回。
		}
		while(head.next!=null) {
			if(head.next.val!=head.val) {
				head=head.next;
				if(head.next!=null&&head.next.val!=head.val) {//三个不重复的数字
					res.next=new ListNode(head.val);
					res=res.next;
				}else if(head.next==null) {//结尾两个不重复的数字
					res.next=new ListNode(head.val);
					res=res.next;
					res.next=null;
				}
			}else {
				head=head.next;
				res.next=null;
			}
		}
		if(flag)
			return trueres.next;//当重复的时候选择链表头的next返回。
		else
			return trueres;
    }
}
