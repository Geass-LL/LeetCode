package Leet;

import DS.TreeNode;

//����Ϲдһͨ����Ȼһ��ͨ����������

public class q100 {
	public boolean isSameTree(TreeNode p, TreeNode q) {
        return helper(p,q);
    }
    boolean helper(TreeNode p,TreeNode q){
        if(p!=null&&q!=null){
            if(p.val!=q.val){
                return false;
            }
            return (helper(p.left,q.left)&&helper(p.right,q.right));
        }else if(p==null&&q==null){
            return true;
        }else{
            return false;
        }
    }
}
