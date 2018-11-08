package Leet;

import java.util.*;

import DS.TreeNode;

/*
 * Inorder±éÀú
 */

public class q94 {
	public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList();
        dyp(res,root);
        return res;
    }
	void dyp(List<Integer> res,TreeNode root) {
		if(root!=null) {
			dyp(res,root.left);
			res.add(root.val);
			dyp(res,root.right);
		}
	}
}
