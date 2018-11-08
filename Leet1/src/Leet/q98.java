package Leet;

import java.util.List;

import DS.TreeNode;

/*
 * 维持一个区间，每次迭代的时候根节点的值应该在这个区间内。
 */

public class q98 {
	public boolean isValidBST(TreeNode root) {
		return isValid(root,null,null);
    }
	boolean isValid(TreeNode root,Integer minvalue,Integer maxvalue) {
		if(root==null) return true;
		if(maxvalue!=null&&root.val>=maxvalue) return false;
		if(minvalue!=null&&root.val<=minvalue) return false;
		return isValid(root.left,minvalue,root.val)&&isValid(root.right,root.val,maxvalue);
	}
}