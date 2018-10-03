package main;

import java.util.List;

import DS.ListNode;
import Leet.*;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		q25 solution=new q25();
		ListNode test=new ListNode(1);
		ListNode head=test;
		for (int i=2;i<10;i++) {
			test.next=new ListNode(i);
			test=test.next;
		}
		head.Show();
		solution.reverseKGroup(head, 11).Show();
	}
}
