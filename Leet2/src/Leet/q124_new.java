package Leet;

import DS.TreeNode;

/*自己怎么就想不到呢。
 * 注意人家的写法，子函数的返回值是该节点起始的最大长度，
 * 但是在里面更新的时候是对每个节点都计算了通过这个结点的最大可能长度。
 */

public class q124_new {
	public int maxnum=Integer.MIN_VALUE;
	public int maxPathSum(TreeNode root) {
		if(root==null) {
			return 0;
		}
		cacu(root);
		return maxnum;
    }
	public int cacu(TreeNode root) {
		if(root==null) {
			return 0;
		}
		int temp=root.val,llen=cacu(root.left),rlen=cacu(root.right);
		//在计算最大长度时，以该节点为root的最大长度
		if(llen>0) {
			temp+=llen;
		}
		if(rlen>0) {
			temp+=rlen;
		}
		if(temp>maxnum) {
			maxnum=temp;
		}
		//在计算最大长度时，以该节点为root的最大长度
		return Math.max(root.val, Math.max(root.val+llen, root.val+rlen));//返回结果为以该节点为起始的单链最大长度
	}
}
