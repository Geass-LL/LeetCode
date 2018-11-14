package Leet;

import java.util.*;

import DS.ListNode;
import DS.TreeNode;

/*
 * ʼ��û��������ô������ǰ��ı���������
 */


public class q109 {
	public TreeNode sortedListToBST(ListNode head) {
		if(head==null) {
			return null;
		}else if(head.next==null){
			return new TreeNode(head.val);
		}else{
			ListNode fast=head.next.next;//�ص��ڳ�ʼ����ʱ��slow���趨Ϊ��һ�ģ�����ǰ�벿�ֵĽ�β��
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
