package main;

import java.util.List;

import DS.ListNode;
import Leet.*;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		q24 solution=new q24();
		ListNode test=new ListNode(1);
		ListNode head=test;
		for (int i=2;i<10;i++) {
			test.next=new ListNode(i);
			test=test.next;
		}
		head.Show();
		ListNode res=solution.swapPairs(head);
		res.Show();
	}
}
