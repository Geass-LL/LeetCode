package Leet;

import DS.ListNode;

/*
 * 纪念一下自己第一次独立完成hard问题，但是方法真的是一级简单了。
 * 把链表尾挨个比较过去，取最小的生成新链表。
 * 当所有的链表指向空时，用nullnum记录空链表个数，结束工作。
 * 这里如果初始就有些链表是空的话会有bug，找了很久，于是加了一个listlength的补丁。
 */
public class q23 {
    public ListNode mergeKLists(ListNode[] lists) {
    	ListNode res=new ListNode(0);
    	ListNode head=res;
    	int nullnum=0;
    	if(lists==null||lists.length==0) {
    		System.out.println("null");
    		return null;
    	}
    	int listlength=0;
    	for(int i=0;i<lists.length;i++) {
    		if (lists[i]!=null) {
    			listlength++;
    		}
    	}
    	while(nullnum<listlength) {
	    	int minval=Integer.MAX_VALUE;
	    	int minindex=0;
	        for (int i=0;i<lists.length;i++) {
	        	if(lists[i]!=null) {
	        		if(lists[i].val<minval) {
	        			minindex=i;
	        			minval=lists[i].val;
	        		}
	        	}
	        }
	        lists[minindex]=lists[minindex].next;
	        if(lists[minindex]==null) {
	        	nullnum++;
	        }
	        res.next=new ListNode(minval);
	        res=res.next;
    	}
        return head.next;
    }
}