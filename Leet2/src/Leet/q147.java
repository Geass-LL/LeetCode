package Leet;

import DS.ListNode;

/*
 * ���ǰ��������Ķ���ʵ����һ�£�ע�⣬������ص�����һ��ʼ���Ǵ�С�������ӵĻ����ǲ��÷�ת�ģ������ȽϺá�
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