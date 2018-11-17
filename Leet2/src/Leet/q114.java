package Leet;

import DS.TreeNode;

/*
 * private TreeNode prev = null;
    public void flatten(TreeNode root) {
        if (root == null) return;
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }
 */

public class q114 {
	public void flatten(TreeNode root) {
		helper(root);
    }
	TreeNode helper(TreeNode root) {
		if(root==null)
			return root;
		TreeNode right=helper(root.right);
		root.right=helper(root.left);
		root.left=null;
		TreeNode temp=root;
		while(temp.right!=null) {
			temp=temp.right;
		}
		temp.right=right;
		return root;
	}
}
