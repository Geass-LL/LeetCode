package Leet;

import DS.ListNode;

//采用mergesort的方法，先用快慢指针找到中间节点，再merge。

public class q148 {
	public static ListNode sortList(ListNode head) {
        if(head==null || head.next==null) return head;
        return mergeSort(head);
    }
	private static ListNode mergeSort(ListNode head){
		if(head==null || head.next==null) return head;
		//分治
		ListNode fast=head,slow=head;
		while(fast.next!=null&&fast.next.next!=null) {
			slow=slow.next;
			fast=fast.next.next;
		}
		ListNode left=head,right=slow.next;
		slow.next=null;
		//排序子链表
		left = mergeSort(left);
		right = mergeSort(right);
		//合并
		ListNode res = new ListNode(-1), tempres=res;
		while(left!=null&&right!=null) {
			if(left.val<right.val) {
				tempres.next=left;
				tempres=left;
				left=left.next;
			}else {
				tempres.next=right;
				tempres=right;
				right=right.next;
			}
		}
		if(left==null) 	tempres.next=right;
		else tempres.next=left;
		return res.next;
	}
}
