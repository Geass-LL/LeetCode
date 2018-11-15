package Leet;

import DS.TreeNode;

/*
 * ºÚµ•Ã‚°£
 */

public class q110 {
	public boolean isBalanced(TreeNode root) {
		if(root==null)
            return true;
        else{
            int left=depth(root.left);
            int right=depth(root.right);
            if(left-right<-1||left-right>1)
                return false;
            else
                return isBalanced(root.left)&&isBalanced(root.right);
        }
    }
	public int depth(TreeNode root) {
		if(root==null) {
			return 0;
		}else {
			int left=depth(root.left);
			int right=depth(root.right);
			return Math.max(left, right)+1;
		}
	}
}
