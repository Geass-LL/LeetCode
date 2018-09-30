package main;

import java.util.List;

import DS.ListNode;
import Leet.*;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		q19 solution=new q19();
		ListNode ori=new ListNode(1);
		ListNode oldnode=ori;
		for(int i=2;i<10;i++) {
			ListNode newnode=new ListNode(i);
			oldnode.next=newnode;
			oldnode=newnode;
		}
		ListNode curnode=solution.removeNthFromEnd(ori, 4);
		while(curnode!=null) {
			System.out.println(curnode.val);
			curnode=curnode.next;
		}
	}

}
