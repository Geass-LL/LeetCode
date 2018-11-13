package Leet;

import java.util.*;

import DS.TreeNode;

/*
 * 对q105的一个对称。所不同的是这里的后序对应前面的先序；
 * 					而且和q105的从0->length-1不同的是，这里从length-1->0.
 */

public class q106 {
	public TreeNode buildTree(int[] inorder, int[] postorder) {
        Stack<TreeNode> stack=new Stack<TreeNode>();
        int length=inorder.length;
        int ini=length-1,posti=length-1;
        TreeNode tempnode=null,res=null;
        while(ini>=0) {
        	if(stack.isEmpty()) {
        		if(res==null) {
        			res=new TreeNode(postorder[posti--]);
        			stack.push(res);
        		}else {
        			TreeNode cur=new TreeNode(postorder[posti--]);
        			stack.push(cur);
        			tempnode.left=cur;
        			tempnode=null;
        		}
        	}else if(stack.peek().val!=inorder[ini]) {
        		TreeNode cur=new TreeNode(postorder[posti--]);
        		if(tempnode==null) {
        			stack.peek().right=cur;
        			stack.push(cur);
        		}else {
        			tempnode.left=cur;
        			stack.push(cur);
        			tempnode=null;
        		}
        	}else {
        		tempnode=stack.pop();
        		ini--;
        	}
        }
        return res;
    }
}
