package Leet;

import DS.ListNode;

/*
 * ��ʵҲ���Ǻ��ѣ�ֻ�ǿ�ʼ��ʱ�����������˼·��
 * ���忴����ɣ�д�ú������
 */

public class q92 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
    	ListNode truehead=head,prev=null;
    	int i=1;
    	while(i<m) {
    		prev=head;
    		head=head.next;
    		i++;
    	}
    	ListNode rtail=head,fronttail=prev;
    	ListNode next;
    	while(head!=null&&i<=n) {
    		next=head.next;
    		head.next=prev;
    		prev=head;
    		head=next;
    		i++;
    	}
    	rtail.next=head;
    	if(fronttail==null) {
    		return prev;
    	}else {
    		fronttail.next=prev;
    		return truehead;
    	}
    }
}
