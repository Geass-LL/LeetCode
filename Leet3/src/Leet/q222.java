package Leet;

import DS.TreeNode;

/*
 * （1）先看深度有多少；
 * （2）返回到根节点，看其右侧节点深度是否满足，满足则加上最后一层的一半，（这里就能看出为何最开始的res上没有减一）；
 * （3）不满足，则看根节点变为其左节点，重复(2).
 */

public class q222 {
	public int countNodes(TreeNode root) {
		int res=0;
		if(root==null)	return 0;
		TreeNode cur=root,prev=cur;
		int deep=1;
		while(cur.left!=null) {
			cur=cur.left;
			deep++;
		}
		//到此，计算总共有多深
		int length=(int)Math.pow(2, deep-1);//上面有多少节点，注意不用减一；看下面的程序可以理解；
		res+=length;
		while(deep>1) {
			deep--;
			length/=2;
			if(prev.right!=null&&iscomplete(prev.right,deep)) {
				res+=length;
				prev=prev.right;
			}else if(prev.left!=null){
				prev=prev.left;
			}
		}
		return res;
    }
	boolean iscomplete(TreeNode root,int depth) {
		//返回以root为根节点的树，深度；
		int deep=1;
		while(root.left!=null) {
			deep++;
			root=root.left;
		}
		return deep==depth;
	}
}
