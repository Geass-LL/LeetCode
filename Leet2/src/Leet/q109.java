package Leet;

import java.util.*;

import DS.ListNode;
import DS.TreeNode;

/*
 * 始终没搞明白怎么把链表前面的保存下来。
 */


public class q109 {
	public TreeNode sortedListToBST(ListNode head) {
		if(head==null) {
			return null;
		}else if(head.next==null){
			return new TreeNode(head.val);
		}else{
			ListNode fast=head.next.next;//重点在初始化的时候，slow就设定为慢一拍，它即前半部分的结尾。
			ListNode slow=head;
			while(fast!=null&&fast.next!=null) {
				fast=fast.next.next;
				slow=slow.next;
			}
			TreeNode res=new TreeNode(slow.next.val);
			res.right=sortedListToBST(slow.next.next);
			slow.next=null;
			res.left=sortedListToBST(head);
			return res;
		}
	}
}
