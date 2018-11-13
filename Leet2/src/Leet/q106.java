package Leet;

import java.util.*;

import DS.TreeNode;

/*
 * ��q105��һ���Գơ�����ͬ��������ĺ����Ӧǰ�������
 * 					���Һ�q105�Ĵ�0->length-1��ͬ���ǣ������length-1->0.
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
