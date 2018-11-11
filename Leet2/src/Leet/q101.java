package Leet;

import DS.TreeNode;

/*
 * 挺有意思的，需要再看看。
 */

public class q101 {
	public boolean isSymmetric(TreeNode root) {
		if(root==null) return true;
		else return isSymmetric(root.left,root.right);
    }
	boolean isSymmetric(TreeNode left,TreeNode right) {
		if(left==null&&right==null) {
			return true;
		}else if(left!=null&&right!=null) {
			return isSymmetric(left.left,right.right)&&isSymmetric(left.right,right.left)&&(left.val==right.val);
		}else {
			return false;
		}
	}
}
