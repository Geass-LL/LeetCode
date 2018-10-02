package Leet;

import DS.ListNode;

/*
 * 当lists的长度大于等于2的时候，利用q21中mergeTwoLists的方法循环处理k个的情况
 */

public class q23_merge2k {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0||lists==null){
            return null;
        }else if(lists.length==1){
            return lists[0];
        }else{
            ListNode res=lists[0];
            for (int i=1;i<lists.length;i++){
                res=mergeTwoLists(res,lists[i]);
            }
            return res;
        }
    }
    ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode res=new ListNode(0);
		ListNode head=res;
		while(l1!=null && l2!=null) {
			if(l1.val<l2.val) {
				res.next=l1;
				l1=l1.next;
			}else {
				res.next=l2;
				l2=l2.next;
			}
			res=res.next;
		}
		if(l1!=null) {
			res.next=l1;
		}else {
			res.next=l2;
		}
		return head.next;
	}
}
