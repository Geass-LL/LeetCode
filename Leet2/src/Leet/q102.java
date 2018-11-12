package Leet;

import java.util.*;

import DS.TreeNode;

/*
 * 感觉仔细想想可以解出来，看OneNote。
 */

public class q102 {
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> res=new ArrayList<List<Integer>>();
		if(root==null) {
			return res;
		}else {
			Queue<TreeNode> queue=new LinkedList<TreeNode>();
			queue.add(root);
			int qsize=1;
			while(!queue.isEmpty()) {
				int pushsize=qsize;
				qsize=0;
				List<Integer> curlevel=new ArrayList<Integer>();
				while(pushsize>0) {
					TreeNode tempnode=queue.poll();
                    pushsize--;
					if(tempnode!=null) {
						curlevel.add(tempnode.val);
						if(tempnode.left!=null) {
							queue.add(tempnode.left);
							qsize++;
						}
						if(tempnode.right!=null) {
							queue.add(tempnode.right);
							qsize++;
						}
					}else {
						break;
					}
				}
				if(curlevel.size()>0)
					res.add(curlevel);
			}
			return res;
		}
    }
}
