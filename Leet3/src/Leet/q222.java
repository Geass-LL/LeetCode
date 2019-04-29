package Leet;

import DS.TreeNode;

/*
 * ��1���ȿ�����ж��٣�
 * ��2�����ص����ڵ㣬�����Ҳ�ڵ�����Ƿ����㣬������������һ���һ�룬��������ܿ���Ϊ���ʼ��res��û�м�һ����
 * ��3�������㣬�򿴸��ڵ��Ϊ����ڵ㣬�ظ�(2).
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
		//���ˣ������ܹ��ж���
		int length=(int)Math.pow(2, deep-1);//�����ж��ٽڵ㣬ע�ⲻ�ü�һ��������ĳ��������⣻
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
		//������rootΪ���ڵ��������ȣ�
		int deep=1;
		while(root.left!=null) {
			deep++;
			root=root.left;
		}
		return deep==depth;
	}
}
