package Leet;

import java.util.*;

import DS.TreeNode;

/*
 * ²Î¿¼ÍøÖ·£º
 * https://blog.csdn.net/qq508618087/article/details/50500754
 */

public class q173 {
	public Stack<TreeNode> st=new Stack<TreeNode>();
	
	public q173(TreeNode root) {
        if(root==null) return;
        while(root!=null) {
        	st.push(root);
        	root=root.left;
        }
    }
    
    /** @return the next smallest number */
    public int next() {
        TreeNode temp=st.pop();
        int res=temp.val;
        temp=temp.right;
        while(temp!=null) {
        	st.push(temp);
        	temp=temp.left;
        }
        return res;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !st.empty();
    }
}
