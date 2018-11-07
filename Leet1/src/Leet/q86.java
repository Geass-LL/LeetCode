package Leet;

import DS.ListNode;

/*
 * 感觉比较简单。
 */

public class q86 {
    public ListNode partition(ListNode head, int x) {
    	ListNode less=new ListNode(0);
    	ListNode greater=new ListNode(0);
    	ListNode trueless=less,truegreater=greater;
    	while(head!=null) {
    		if(head.val<x) {
    			less.next=head;
    			less=head;
    		}else {
    			greater.next=head;
    			greater=head;
    		}
    		head=head.next;
    	}
    	less.next=null;
    	greater.next=null;
    	if(trueless.next==null) {
    		return truegreater.next;
    	}else {
    		less.next=truegreater.next;
    		return trueless.next;
    	}
    }
}
