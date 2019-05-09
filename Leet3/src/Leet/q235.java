package Leet;

import java.util.*;

import DS.TreeNode;

/*
 * 先把这两个数用深度优先搜索找出来，并记录寻找的路径；然后比较路径，直到无法找到相同路径。
 */

public class q235 {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if(root==null||p==null||q==null)	return null;
		List<TreeNode> resp=new ArrayList<TreeNode>(),resq=new ArrayList<TreeNode>();
		resq.add(root);
		resp.add(root);
		int[] state= {0};
		btk(root,p,resp,state);
		state[0]=0;
		btk(root,q,resq,state);
		int i=0;
		for(i=0;i<Math.min(resq.size(), resp.size());i++) {
			if(resq.get(i)!=resp.get(i))	break;
		}
		return resq.get(i-1);
    }
	void btk(TreeNode root,TreeNode target,List<TreeNode> res,int[] state) {
		if(root==target) {
			state[0]=1;
			return;
		}else {
			if(root.left!=null) {
				res.add(root.left);
				btk(root.left,target,res,state);
				if(state[0]==0)	res.remove(res.size()-1);
			}
			if(root.right!=null) {
				res.add(root.right);
				btk(root.right,target,res,state);
				if(state[0]==0)	res.remove(res.size()-1);
			}
		}
	}
}
