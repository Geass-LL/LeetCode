package Leet;

import java.util.*;
import DS.TreeNode;
/*
 * ʹ��������ջ��һ��ջ���ڴ洢��ǰ�Ľ�������浽prevstack�У� 
 * ����һ��ջ�ǰѴ����ֵ�ָ�������
 * ʹ��leftflag������zigzag�ķ���
 */
public class q103 {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> res=new ArrayList<List<Integer>>();
		if(root==null) {
			return res;
		}else {
			Stack<TreeNode> prevstack=new Stack<TreeNode>();
			prevstack.push(root);
			boolean leftflag=true;
			while(prevstack.size()>0) {
				Stack<TreeNode> stack=prevstack;
				prevstack=new Stack<TreeNode>();
				List<Integer> curlevel=new ArrayList<Integer>();
				while(!stack.isEmpty()) {
					TreeNode tempnode=stack.pop();
					curlevel.add(tempnode.val);
					if(leftflag) {
						if(tempnode.left!=null) {
							prevstack.push(tempnode.left);
						}
						if(tempnode.right!=null) {
							prevstack.push(tempnode.right);
						}
					}else {
						if(tempnode.right!=null) {
							prevstack.push(tempnode.right);
						}
						if(tempnode.left!=null) {
							prevstack.push(tempnode.left);
						}
					}
				}
				res.add(curlevel);
				leftflag=!leftflag;
			}
			return res;
		}
    }
}
