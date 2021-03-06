package Leet;

import java.util.List;

import DS.TreeNode;

/*
 * 中序排列必定为升序，否则就是有问题的节点。
 */
public class q99 {
	TreeNode t1,t2;
	TreeNode pre=new TreeNode(Integer.MIN_VALUE);
    public void recoverTree(TreeNode root) {
        bfs(root);
		int temp=t1.val;
		t1.val=t2.val;
		t2.val=temp;
    }
    private void bfs(TreeNode root) {
		if(root==null){
			return;
		}
		bfs(root.left);
		//中序遍历中间处理
		if(t1==null&&pre.val>=root.val){
			t1=pre;
		}
		if(t1!=null&&pre.val>=root.val){
			t2=root;
		}
		pre=root;
		//处理结束		
		bfs(root.right);
    }
}
