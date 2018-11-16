package Leet;

import java.util.*;

import DS.TreeNode;

/*
 * ��ʼ��ʱ��tempres.add(root.val)�����left��rightͬʱ����root.val��������ĳ�tempres.add(left.val)�����ˡ�
 */

public class q113 {
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        if(root==null) return res;
        List<Integer> tempres=new ArrayList<Integer>();
        tempres.add(root.val);
        btk(res,tempres,root,sum-root.val);
        return res;
    }
	void btk(List<List<Integer>> res, List<Integer> tempres, TreeNode root, int sum) {
		if(root.left==null&&root.right==null) {
			if(sum==0) {
				res.add(new ArrayList(tempres));
			}
		}else {
			if(root.left!=null) {
				tempres.add(root.left.val);
				btk(res, tempres, root.left, sum-root.left.val);
				tempres.remove(tempres.size()-1);
			}
			if(root.right!=null) {
				tempres.add(root.right.val);
				btk(res,tempres,root.right,sum-root.right.val);
				tempres.remove(tempres.size()-1);
			}
		}
	}
}
