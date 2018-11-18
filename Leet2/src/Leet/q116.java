package Leet;

import DS.TreeLinkNode;

/*
 * 妈呀，瞎逼写了一通，一次通过，简直吓到自己。
 * 类似层次遍历的写法。
 */
public class q116 {
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
