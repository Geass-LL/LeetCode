package Leet;

import java.util.*;

import DS.TreeNode;

/*
 * 先把这两个数用深度优先搜索找出来，并记录寻找的路径；然后比较路径，直到无法找到相同路径。
 */

public class q235 {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if(root==null||p==null||q==null) {
			return null;
		}
		while(root!=null) {
			if(p.val<root.val&&q.val<root.val)	root=root.left;
			else if(p.val>root.val&&q.val>root.val)	root=root.right;
			else	break;
		}
		return root;
	}
}
