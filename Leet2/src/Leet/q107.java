package Leet;

import java.util.*;
import DS.TreeNode;

/*
 * 搞不懂这个题存在的意义，最后就把q102的结果反向了一下结束了。还以为有什么特殊的技巧呢。
 */

public class q107 {
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
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
			Collections.reverse(res);
            return res;
		}
    }
}
