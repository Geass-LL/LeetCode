package Leet;

import DS.ListNode;
/*
 * 基于链表反转，k个元素的反转。
 */
public class q25 {
    public ListNode reverseKGroup(ListNode head, int k) {
    	//排除特殊情况
    	if (biggerthan(head,k)) {
    		//依次反转k个链表元素，并返回链表头
        	head=reverse(head,k);
        	return head;
    	}else {
    		return head;
    	}
    }
    ListNode reverse(ListNode head,int k) {
    	ListNode tail=head;//保存链表的尾部，即反转前的头部
    	ListNode prev=null;
    	ListNode now=head;
    	ListNode next=null;
    	int deep=0;
    	while(now!=null && deep<k) {
    		//链表反转NNNPPNNN
    		next=now.next;
    		now.next=prev;
    		prev=now;
    		now=next;
    		deep++;
    	}
    	//结果，只需要初始化一次
    	final ListNode res=prev;
    	//如果链表的长度还是很长，那么迭代反转，将上一列表的尾部指向新链表的头
    	if(biggerthan(next,k)) {
    		tail.next=reverse(next,k);
    	}else {
    		//如果链表不长了，那么不必反转，直接尾部接到下一个头部
    		tail.next=next;
    	}
    	return res;
    }
    //判断待反转链表长度是否大于设定值
    boolean biggerthan(ListNode head,int k) {
    	int length=0;
    	while(head!=null) {
    		length++;
    		if(length>=k) {
    			return true;
    		}
    		head=head.next;
    	}
    	return false;
    }
}
