package Leet;

import DS.TreeNode;

public class q104 {
	public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }else{
        	int leftdepth,rightdepth;
            if(root.left!=null)
            	leftdepth=maxDepth(root.left)+1;
            else
            	leftdepth=1;
            if(root.right!=null)
            	rightdepth=maxDepth(root.right)+1;
            else
            	rightdepth=1;
            return Math.max(leftdepth, rightdepth);
        }
    }
}
