package Leet;

import java.util.*;

import DS.TreeNode;

/*
 * 不会做，参考博客：
 * http://www.cnblogs.com/ganganloveu/p/4138344.html
 */

public class q95 {
	public List<TreeNode> generateTrees(int n) {
		List<TreeNode> res=new ArrayList();
        if(n==0)
            return res;
        else
		    return dyp(1,n);
    }
	List<TreeNode> dyp(int begin,int end){
		List<TreeNode> res=new ArrayList();
		if(begin<end) {
			res.add(null);
		}else if(begin==end) {
			res.add(new TreeNode(begin));
		}else {
			for(int i=begin;i<=end;i++) {
				List<TreeNode> left=dyp(begin,i-1);
				List<TreeNode> right=dyp(i+1,end);
				for(int l=0;l<left.size();l++) {
					for(int r=0;r<right.size();r++) {
						TreeNode root=new TreeNode(i);
						root.left=left.get(l);
						root.right=right.get(r);
						res.add(root);
					}
				}
			}
		}
		return res;
	}
}
