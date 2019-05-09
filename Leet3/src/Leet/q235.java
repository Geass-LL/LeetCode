package Leet;

import java.util.*;

import DS.TreeNode;

/*
 * �Ȱ�����������������������ҳ���������¼Ѱ�ҵ�·����Ȼ��Ƚ�·����ֱ���޷��ҵ���ͬ·����
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
