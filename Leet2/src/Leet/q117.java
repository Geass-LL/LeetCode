package Leet;

import DS.TreeLinkNode;

public class q117 {
	public void connect(TreeLinkNode root) {
        while(root!=null) {
        	TreeLinkNode now=new TreeLinkNode(0),truenow=now;
        	while(root!=null) {
        		if(root.left!=null) {
        			now.next=root.left;
        			now=now.next;
        		}
        		if(root.right!=null) {
        			now.next=root.right;
        			now=now.next;
        		}
        		root=root.next;
        	}
        	now.next=null;
        	root=truenow.next;
        }
    }
}
