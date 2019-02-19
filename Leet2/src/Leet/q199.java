package Leet;

import java.util.*;

import DS.TreeNode;

public class q199 {
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> res=new ArrayList<Integer>();
		btk(root,res,0);
		return res;
    }
	void btk(TreeNode root,List<Integer> res,int depth) {
		if(root==null) return;
		if(depth==res.size()) {
			res.add(root.val);
		}
		btk(root.right,res,depth+1);
		btk(root.left,res,depth+1);
	}
}
