package Leet;

import DS.TreeNode;

public class q129 {
	public int res=0;
	public int sumNumbers(TreeNode root) {
		if(root==null) return 0;
		btk(root,0);
		return res;
    }
	void btk(TreeNode root,int tempres) {
		tempres=tempres*10+root.val;
		if(root.left==null&&root.right==null) {
			res+=tempres;
		}
		if(root.left!=null) {
			btk(root.left,tempres);
		}
		if(root.right!=null) {
			btk(root.right,tempres);
		}
	}
}
