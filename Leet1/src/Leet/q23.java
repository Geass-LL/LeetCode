package Leet;

import DS.ListNode;

/*
 * ����һ���Լ���һ�ζ������hard���⣬���Ƿ��������һ�����ˡ�
 * ������β�����ȽϹ�ȥ��ȡ��С������������
 * �����е�����ָ���ʱ����nullnum��¼���������������������
 * ���������ʼ����Щ�����ǿյĻ�����bug�����˺ܾã����Ǽ���һ��listlength�Ĳ�����
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