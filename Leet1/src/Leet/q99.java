package Leet;

import java.util.List;

import DS.TreeNode;

/*
 * �������бض�Ϊ���򣬷������������Ľڵ㡣
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
		//��������м䴦��
		if(t1==null&&pre.val>=root.val){
			t1=pre;
		}
		if(t1!=null&&pre.val>=root.val){
			t2=root;
		}
		pre=root;
		//�������		
		bfs(root.right);
    }
}
