package Leet;

import DS.TreeNode;

public class q112 {
	public boolean hasPathSum(TreeNode root, int sum) {
		if(root==null) {
			return false;
		}
		if(root.left!=null&&root.right!=null) {
			return hasPathSum(root.left,sum-root.val)||hasPathSum(root.right,sum-root.val);
		}else if(root.left==null&&root.right!=null) {
			return hasPathSum(root.right,sum-root.val);
		}else if(root.right==null&&root.left!=null) {
			return hasPathSum(root.left,sum-root.val);
		}else {
			if(root.val==sum) {
				return true;
			}else {
				return false;
			}
		}
    }
}
