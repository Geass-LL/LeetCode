package Leet;

import java.util.*;

import DS.TreeNode;

/*
 * �Ȱ�����������������������ҳ���������¼Ѱ�ҵ�·����Ȼ��Ƚ�·����ֱ���޷��ҵ���ͬ·����
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
