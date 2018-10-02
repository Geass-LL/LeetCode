package main;

import java.util.List;

import DS.ListNode;
import Leet.*;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		q23 solution=new q23();
		ListNode a=new ListNode(1);
		ListNode b=new ListNode(1);
		ListNode c=new ListNode(3);
		a.next=new ListNode(3);
		a.next.next=new ListNode(5);
		b.next=new ListNode(2);
		b.next.next=new ListNode(4);
		c.next=new ListNode(7);
		ListNode[] test= {null,b,c};
		ListNode res=solution.mergeKLists(test);
		while(res!=null) {
			System.out.println(res.val);
			res=res.next;
		}
	}
}
