package Leet;

import DS.TreeNode;

/*
 * 中序遍历的第k个值，即为BST的第k小的值。
 */

public class q230 {
	public int count=0;
	public int kthSmallest(TreeNode root, int k) {
        int[] pra={k,0};
        help(root,pra);
        return pra[1];
    }
    public void help(TreeNode root,int[] pra){
        if(root.left!=null){
            help(root.left,pra);
        }
        count++;
        if(count==pra[0]){
            pra[1]=root.val;
            return;
        }
        if(root.right!=null){
            help(root.right,pra);
        }
    }
}
