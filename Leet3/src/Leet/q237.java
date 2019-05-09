package Leet;

import DS.ListNode;

public class q237 {
	public void deleteNode(ListNode node) {
        node.val=node.next.val;
        while(node.next.next!=null){
            node.next.val=node.next.next.val;
            node=node.next;
        }
        node.next=null;
    }
}
