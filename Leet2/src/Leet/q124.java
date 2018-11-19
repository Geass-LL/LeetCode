package Leet;

import DS.TreeNode;

public class q124 {
	public int maxPathSum(TreeNode root) {
		int[] res= {Integer.MIN_VALUE};
		helper(root,res);
		root.Show();
		return res[0];
    }
	int helper(TreeNode root,int[] res) {
		if(root.left==null&&root.right==null) {
		}else if(root.left!=null&&root.right==null) {
			root.val=Math.max(root.val, helper(root.left,res)+root.val);
		}else if(root.left==null&&root.right!=null) {
			root.val=Math.max(root.val, root.val+helper(root.right,res));
		}else {
			int temp1=helper(root.left,res);
			int temp2=helper(root.right,res);
			root.val=Math.max(Math.max(root.val, root.val+temp1+temp2),Math.max(root.val+temp1, root.val+temp2));
		}
		if(root.val>res[0]) res[0]=root.val;
		return root.val;
	}
}
